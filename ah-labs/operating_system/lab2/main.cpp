#include <fcntl.h>
#include <unistd.h>

#include <cerrno>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <new>

int main(int argc, char* argv[]) {
  if (argc != 4) {
    std::fprintf(stderr, "Usage: %s <buffer_size> <input_file> <output_file>\n",
                 argv[0]);
    return 1;
  }

  char* end = nullptr;
  errno = 0;
  long parsed_size = std::strtol(argv[1], &end, 10);

  if (errno != 0 || end == argv[1] || *end != '\0' || parsed_size <= 0) {
    std::fprintf(stderr, "Error: buffer size must be a positive integer\n");
    return 1;
  }

  size_t buffer_size = static_cast<size_t>(parsed_size);
  char* buffer = new (std::nothrow) char[buffer_size];

  if (buffer == nullptr) {
    std::fprintf(stderr, "Error: cannot allocate buffer\n");
    return 1;
  }

  int read_calls = 0;
  int write_calls = 0;
  int open_calls = 0;
  int close_calls = 0;
  int exit_code = 0;

  ++open_calls;
  int input_fd = open(argv[2], O_RDONLY);

  if (input_fd == -1) {
    std::fprintf(stderr, "Cannot open input file: %s\n", std::strerror(errno));
    delete[] buffer;
    return 1;
  }

  ++open_calls;
  int output_fd = open(argv[3], O_WRONLY | O_CREAT | O_TRUNC, 0644);

  if (output_fd == -1) {
    std::fprintf(stderr, "Cannot open output file: %s\n", std::strerror(errno));
    ++close_calls;
    close(input_fd);
    delete[] buffer;
    return 1;
  }

  while (true) {
    ++read_calls;
    ssize_t bytes_read = read(input_fd, buffer, buffer_size);

    if (bytes_read == 0) {
      break;
    }

    if (bytes_read < 0) {
      if (errno == EINTR) {
        continue;
      }
      std::fprintf(stderr, "Read error: %s\n", std::strerror(errno));
      exit_code = 1;
      break;
    }

    ssize_t total_written = 0;

    while (total_written < bytes_read) {
      ++write_calls;
      ssize_t bytes_written =
          write(output_fd, buffer + total_written,
                static_cast<size_t>(bytes_read - total_written));

      if (bytes_written < 0) {
        if (errno == EINTR) {
          continue;
        }
        std::fprintf(stderr, "Write error: %s\n", std::strerror(errno));
        exit_code = 1;
        break;
      }

      if (bytes_written == 0) {
        std::fprintf(stderr, "Write error: no progress\n");
        exit_code = 1;
        break;
      }

      total_written += bytes_written;
    }

    if (exit_code != 0) {
      break;
    }
  }

  ++close_calls;
  if (close(input_fd) == -1) {
    std::fprintf(stderr, "Error closing input file\n");
    exit_code = 1;
  }

  ++close_calls;
  if (close(output_fd) == -1) {
    std::fprintf(stderr, "Error closing output file\n");
    exit_code = 1;
  }

  std::fprintf(stderr,
               "Buffer size: %zu bytes\n"
               "read() calls: %d\n"
               "write() calls: %d\n"
               "open() calls: %d\n"
               "close() calls: %d\n"
               "Total counted calls: %d\n",
               buffer_size, read_calls, write_calls, open_calls, close_calls,
               read_calls + write_calls + open_calls + close_calls);

  delete[] buffer;
  return exit_code;
}
