#include <sys/wait.h>
#include <unistd.h>

#include <iostream>
#include <thread>
#include <vector>

void run_processes_part() {
  std::cout << "Parent pid=" << getpid() << std::endl;

  const int N = 3;

  for (int i = 0; i < N; ++i) {
    pid_t pid = fork();

    if (pid == 0) {
      std::cout << "Child #" << i + 1 << " pid=" << getpid()
                << " ppid=" << getppid() << std::endl;
      _exit(0);
    }
  }

  for (int i = 0; i < N; ++i) {
    wait(nullptr);
  }

  std::cout << "Parent: all children finished" << std::endl;
}

void run_threads_part() {
  const int N = 3;
  std::vector<std::thread> threads;

  for (int i = 0; i < N; ++i) {
    threads.emplace_back([i]() {
      std::cout << "Thread #" << i + 1
                << " thread id=" << std::this_thread::get_id() << std::endl;
    });
  }

  for (auto& t : threads) {
    t.join();
  }

  std::cout << "All threads finished" << std::endl;
}

int main() {
  run_processes_part();
  run_threads_part();
  return 0;
}