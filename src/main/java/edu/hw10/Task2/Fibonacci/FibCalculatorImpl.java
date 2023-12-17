package edu.hw10.Task2.Fibonacci;

public class FibCalculatorImpl implements FibCalculator {

    @Override
    public long fib(int number) {
        if (number < 2) {
            return number;
        }

        return fib(number - 1) + fib(number - 2);
    }
}
