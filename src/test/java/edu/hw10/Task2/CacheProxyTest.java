package edu.hw10.Task2;

import edu.hw10.Task2.Fibonacci.FibCalculator;
import edu.hw10.Task2.Fibonacci.FibCalculatorImpl;
import edu.hw10.Task2.caches.CacheProxy;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CacheProxyTest {
    @Test
    void test_create_method() throws IOException {
        File file = new File("src/main/resources/cache.txt");
        FibCalculator fib = new FibCalculatorImpl();
        FibCalculator proxyFib = CacheProxy.create(fib, FibCalculator.class,
            file);

        assertThat(proxyFib).isNotNull();
        file.deleteOnExit();
    }
}
