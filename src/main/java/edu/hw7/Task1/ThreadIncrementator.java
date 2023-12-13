package edu.hw7.Task1;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadIncrementator implements Runnable {
    private final AtomicInteger counter;

    ThreadIncrementator() {
        counter = new AtomicInteger(0);
    }

    private void increment() {
        counter.incrementAndGet();
    }

    public int getCounter() {
        return counter.get();
    }

    @Override
    public void run() {
        increment();
    }
}
