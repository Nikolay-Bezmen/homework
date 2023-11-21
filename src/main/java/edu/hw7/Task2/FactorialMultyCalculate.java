package edu.hw7.Task2;

import java.util.List;
import java.util.stream.LongStream;

public class FactorialMultyCalculate {
    private FactorialMultyCalculate() {
    }

    public static long calculateFactorial(int n) {
        List<Long> list = LongStream.range(1, n + 1).boxed().toList();

        return list.parallelStream().reduce((a, b) -> a * b).orElse(1L);
    }
}
