package edu.hw7.Task1;

public class MultyThreadIncrementator {
    private MultyThreadIncrementator() {
    }

    public static int multyThreadIncrementator(int countIncrements) throws InterruptedException {
        ThreadIncrementator threadIncrementator = new ThreadIncrementator();
        Thread[] threads = new Thread[countIncrements];

        for (int i = 0; i < countIncrements; ++i) {
            threads[i] = new Thread(threadIncrementator);
        }

        for (int i = 0; i < countIncrements; ++i) {
            threads[i].start();
        }

        for (int i = 0; i < countIncrements; ++i) {
            threads[i].join();
        }

        return threadIncrementator.getCounter();
    }
}
