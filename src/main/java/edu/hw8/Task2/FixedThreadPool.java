package edu.hw8.Task2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class FixedThreadPool implements ThreadPool {
    private final Thread[] threads;
    private final Queue<Runnable> tasks = new ArrayDeque<>();

    private FixedThreadPool(int countThreads) {
        threads = new Thread[countThreads];

        for (int i = 0; i < countThreads; ++i) {
            threads[i] = new Thread(new RunnableTask());
        }
    }

    public static FixedThreadPool create(int countThreads) {
        return new FixedThreadPool(countThreads);
    }

    @Override
    public void start() {
        Arrays.stream(threads).forEach(Thread::start);
    }

    @Override
    public void execute(Runnable runnable) {
        synchronized (tasks) {
            tasks.offer(runnable);
            tasks.notify();
        }
    }

    @Override
    public void close() {
        Arrays.stream(threads).forEach(Thread::interrupt);
    }

    public boolean smartClose() {
        synchronized (tasks) {
            if (tasks.isEmpty()) {
                close();
                return true;
            } else {
                return false;
            }
        }
    }

    private class RunnableTask implements Runnable {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                Runnable newTask = getTaskFromQueue();

                try {
                    newTask.run();
                } catch (RuntimeException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        private Runnable getTaskFromQueue() {
            synchronized (tasks) {
                while (tasks.isEmpty()) {
                    try {
                        tasks.wait();
                    } catch (InterruptedException e) {
                        return null;
                    }
                }
                return tasks.poll();
            }
        }
    }
}
