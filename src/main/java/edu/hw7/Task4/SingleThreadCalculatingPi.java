package edu.hw7.Task4;

import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("MagicNumber")
public class SingleThreadCalculatingPi {
    static final int SIDE = 1_000;
    static final int RADIUS = SIDE / 2;

    public double getPi(long simulation) {
        int countPointInCircle = 0;
        for (int i = 0; i < simulation; ++i) {
            int x = ThreadLocalRandom.current().nextInt(0, SIDE + 1);
            int y = ThreadLocalRandom.current().nextInt(0, SIDE + 1);

            if (Math.sqrt(Math.pow(RADIUS - x, 2) + Math.pow(RADIUS - y, 2)) <= RADIUS) {
                ++countPointInCircle;
            }
        }

        return 4.0 * countPointInCircle / simulation;
    }
}
