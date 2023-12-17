package edu.hw10.Task2;

import edu.hw10.Task2.Fibonacci.FibCalculator;
import edu.hw10.Task2.Fibonacci.FibCalculatorImpl;
import edu.hw10.Task2.caches.CacheProxy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

public class CacheInvocationHandlerTest {
    private File file;
    @BeforeEach void setup(){
        file = new File("src/main/resources/cache.txt");
    }
    @Test
    void test_call_method_who_contains_cache() throws IOException {
        FibCalculator fibCalculator = new FibCalculatorImpl();
        FibCalculator proxyFibCalculator = CacheProxy.create(fibCalculator,
            FibCalculator.class, file);

        proxyFibCalculator.fib(1);

        assertThat(file.exists()).isTrue();
        assertThat(file.length()).isGreaterThan(0);
    }

    @Test
    @DisplayName("проверка что кэши используютяся корректно")
    void test_that_used_cache_from_previous_called_is_correct() throws IOException {
        FibCalculator fibCalculator = new FibCalculatorImpl();
        FibCalculator proxyFibCalculator = CacheProxy.create(fibCalculator,
            FibCalculator.class, file);

        proxyFibCalculator.fib(4);
        long fibNumber = proxyFibCalculator.fib(5);
        long correctFibNumber = 5;

        assertThat(fibNumber).isEqualTo(correctFibNumber);
    }

    @Test
    @DisplayName("проверка того что кэш и вычисленное значение корректны")
    void test_that_cache_value_is_correct() throws IOException {
        FibCalculator fibCalculator = new FibCalculatorImpl();
        FibCalculator proxyFibCalculator = CacheProxy.create(fibCalculator,
            FibCalculator.class, file);

        long fib1 = proxyFibCalculator.fib(5);
        long fibFromCache = proxyFibCalculator.fib(5);

        assertThat(fib1).isEqualTo(fibFromCache);
    }

    @AfterEach void deleteCache(){
        file.delete();
    }
}
