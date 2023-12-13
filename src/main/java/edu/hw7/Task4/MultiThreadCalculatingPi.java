package edu.hw7.Task4;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

@SuppressWarnings("MagicNumber")
public class MultiThreadCalculatingPi {
    static final int SIDE = 1_000;
    static final int RADIUS = SIDE / 2;

    public double getPi(long simulation, int countThreads) {
        Thread[] threads = new Thread[countThreads];
        long averageCountSimulationOnOneThread = simulation / countThreads;
        AtomicLong circleCount = new AtomicLong(0);

        for (int i = 0; i < countThreads; ++i) {
            threads[i] = new Thread(() ->
                circleCount.addAndGet(getCountPointsInCircle(averageCountSimulationOnOneThread)));
            threads[i].start();
        }

        try {
            for (int i = 0; i < countThreads; ++i) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return 4.0 * circleCount.get() / simulation;
    }

    private long getCountPointsInCircle(long totalCountPoint) {
        int countPointInCircle = 0;
        for (int i = 0; i < totalCountPoint; ++i) {
            int x = ThreadLocalRandom.current().nextInt(0, SIDE + 1);
            int y = ThreadLocalRandom.current().nextInt(0, SIDE + 1);

            if (Math.sqrt(Math.pow(RADIUS - x, 2) + Math.pow(RADIUS - y, 2)) <= RADIUS) {
                ++countPointInCircle;
            }
        }

        return countPointInCircle;
    }
}
