#include <fcntl.h>
#include <unistd.h>

#include <cerrno>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <vector>

int main(int argc, char* argv[]) {
  if (argc < 2) {
    fprintf(stderr, "Usage: %s buffer_size [input_file] [output_file]\n",
            argv[0]);
    fprintf(stderr,
            "If input_file/output_file are omitted, stdin/stdout are used.\n");
    return 1;
  }

  size_t buf_size = strtoul(argv[1], nullptr, 10);
  if (buf_size == 0) {
    fprintf(stderr, "buffer_size must be a positive integer\n");
    return 1;
  }

  int in_fd = STDIN_FILENO;
  int out_fd = STDOUT_FILENO;

  if (argc >= 3) {
    in_fd = open(argv[2], O_RDONLY);
    if (in_fd < 0) {
      perror("open input");
      return 1;
    }
  }

  if (argc >= 4) {
    out_fd = open(argv[3], O_WRONLY | O_CREAT | O_TRUNC, 0644);
    if (out_fd < 0) {
      perror("open output");
      return 1;
    }
  }

  std::vector<char> buffer(buf_size);
  ssize_t n_read;

  while ((n_read = read(in_fd, buffer.data(), buf_size)) > 0) {
    ssize_t written_total = 0;
    while (written_total < n_read) {
      ssize_t n_written =
          write(out_fd, buffer.data() + written_total, n_read - written_total);
      if (n_written < 0) {
        perror("write");
        return 1;
      }
      written_total += n_written;
    }
  }

  if (n_read < 0) {
    perror("read");
    return 1;
  }

  if (argc >= 3) close(in_fd);
  if (argc >= 4) close(out_fd);

  return 0;
}