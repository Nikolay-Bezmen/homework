package edu.hw8.Task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"MagicNumber", "HideUtilityClassConstructor", "UncommentedMain"})
public class FibonacciCalculateDemonstration {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        FixedThreadPool threadPool = FixedThreadPool.create(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < 64; ++i) {
            int finalI = i;
            threadPool.execute(() -> LOGGER.info("result calculate " + finalI + " " + fibonacciCalculate(finalI)));
        }
        threadPool.start();

        while (true) {
            if (threadPool.smartClose()) {
                break;
            }
        }
    }

    private static long fibonacciCalculate(long n) {
        if (n <= 1) {
            return n;
        }

        long prev = 0L;
        long curr = 1L;
        for (int i = 2; i <= n; i++) {
            long summary = prev + curr;
            prev = curr;
            curr = summary;

        }

        return curr;
    }
}
