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
        if (n < 2) {
            return n;
        }

        long[] startMatrix = {1, 1, 1, 0};
        long[] result = pow(startMatrix, n - 1);

        return result[0];
    }

    private static long[] pow(long[] matrix, long n) {
        if (n == 1) {
            return matrix;
        }

        if (n % 2 == 0) {
            return pow(multiply(matrix, matrix), n / 2);
        }

        return multiply(matrix, pow(matrix, n - 1));
    }

    private static long[] multiply(long[] matrix1, long[] matrix2) {
        long[] resultMultiply = new long[4];

        resultMultiply[0] = matrix1[0] * matrix2[0] + matrix1[1] * matrix2[2];
        resultMultiply[1] = matrix1[0] * matrix2[1] + matrix1[1] * matrix2[3];
        resultMultiply[2] = resultMultiply[1];
        resultMultiply[3] = matrix1[2] * matrix2[1] + matrix1[3] * matrix2[3];

        return resultMultiply;
    }
}
