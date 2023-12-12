package edu.hw10.Task2.Fibonacci;

import edu.hw10.Task2.annotations.Cache;

public interface FibCalculator {
    @Cache(persist = true)
    long fib(int number);
}
