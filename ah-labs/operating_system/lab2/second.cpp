#include <fcntl.h>
#include <unistd.h>

#include <cstdlib>
#include <iostream>

int main(int argc, char* argv[]) {
  if (argc != 4) {
    std::cerr << "Usage: " << argv[0]
              << " <buffer_size> <input_file> <output_file>\n";
    return 1;
  }

  long buffer_size = std::atol(argv[1]);

  if (buffer_size <= 0) {
    std::cerr << "Error: buffer size must be greater than 0\n";
    return 1;
  }

  int input_fd = open(argv[2], O_RDONLY);

  if (input_fd == -1) {
    std::cerr << "Error: cannot open input file\n";
    return 1;
  }

  int output_fd = open(argv[3], O_WRONLY | O_CREAT | O_TRUNC, 0644);

  if (output_fd == -1) {
    std::cerr << "Error: cannot open output file\n";
    close(input_fd);
    return 1;
  }

  char* buffer = new char[buffer_size];

  while (true) {
    ssize_t bytes_read = read(input_fd, buffer, buffer_size);

    if (bytes_read == 0) {
      break;
    }

    if (bytes_read == -1) {
      std::cerr << "Error: read failed\n";

      delete[] buffer;
      close(input_fd);
      close(output_fd);

      return 1;
    }

    ssize_t total_written = 0;

    while (total_written < bytes_read) {
      ssize_t bytes_written =
          write(output_fd, buffer + total_written, bytes_read - total_written);

      if (bytes_written == -1) {
        std::cerr << "Error: write failed\n";

        delete[] buffer;
        close(input_fd);
        close(output_fd);

        return 1;
      }

      total_written += bytes_written;
    }
  }

  delete[] buffer;

  close(input_fd);
  close(output_fd);

  return 0;
}