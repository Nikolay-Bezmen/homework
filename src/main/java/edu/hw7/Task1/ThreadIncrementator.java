package edu.hw7.Task1;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadIncrementator implements Runnable {
    private final AtomicInteger COUNTER;

    ThreadIncrementator() {
        COUNTER = new AtomicInteger(0);
    }

    private void increment() {
        COUNTER.incrementAndGet();
    }

    public int getCounter() {
        return COUNTER.get();
    }

    @Override
    public void run() {
        increment();
    }
}
