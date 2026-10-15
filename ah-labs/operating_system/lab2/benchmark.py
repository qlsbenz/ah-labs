
#!/usr/bin/env python3

import csv
import os
import re
import subprocess
import sys
import time
import resource

PROGRAM = "./copy_buffer"
INPUT = "input.bin"
OUTPUT = "output.bin"
RESULTS = "results.csv"
REPEATS = 5

SIZES = [
    1, 4, 16, 32, 64, 256,
    1024, 4096, 16384, 65536,
    262144, 524288, 1048576
]


def get_count(log, name):
    pattern = rf"^{re.escape(name)}:\s*(\d+)\s*$"
    match = re.search(pattern, log, re.MULTILINE)
    if match is None:
        raise ValueError(f"Cannot find counter: {name}")
    return int(match.group(1))


def main():
    if not os.path.isfile(PROGRAM) or not os.access(PROGRAM, os.X_OK):
        sys.exit("Error: ./copy_buffer not found or not executable")

    if not os.path.isfile(INPUT):
        sys.exit("Error: input.bin not found")

    columns = [
        "buffer_bytes", "run", "real", "user", "sys",
        "read_calls", "write_calls", "open_calls",
        "close_calls", "total_calls"
    ]

    with open(RESULTS, "w", newline="") as csv_file:
        writer = csv.DictWriter(csv_file, fieldnames=columns)
        writer.writeheader()

        for size in SIZES:
            for run in range(1, REPEATS + 1):
                # Resource usage of previously completed child processes.
                before = resource.getrusage(resource.RUSAGE_CHILDREN)

                start = time.perf_counter_ns()
                result = subprocess.run(
                    [PROGRAM, str(size), INPUT, OUTPUT],
                    stdout=subprocess.DEVNULL,
                    stderr=subprocess.PIPE,
                    text=True
                )
                elapsed_ns = time.perf_counter_ns() - start

                after = resource.getrusage(resource.RUSAGE_CHILDREN)

                if result.returncode != 0:
                    print(result.stderr, file=sys.stderr)
                    sys.exit(
                        f"Error: buffer={size}, run={run}, "
                        f"exit code={result.returncode}"
                    )

                log = result.stderr

                row = {
                    "buffer_bytes": size,
                    "run": run,
                    "real": f"{elapsed_ns / 1_000_000_000:.9f}",
                    "user": f"{max(0, after.ru_utime - before.ru_utime):.6f}",
                    "sys": f"{max(0, after.ru_stime - before.ru_stime):.6f}",
                    "read_calls": get_count(log, "read() calls"),
                    "write_calls": get_count(log, "write() calls"),
                    "open_calls": get_count(log, "open() calls"),
                    "close_calls": get_count(log, "close() calls"),
                    "total_calls": get_count(log, "Total counted calls"),
                }

                writer.writerow(row)
                csv_file.flush()

                print(
                    f"Buffer={size:7} bytes | run={run}/{REPEATS} | "
                    f"real={row['real']} s | "
                    f"user={row['user']} s | sys={row['sys']} s"
                )

    print(f"\nDone. Results saved to {RESULTS}")


if __name__ == "__main__":
    main()
