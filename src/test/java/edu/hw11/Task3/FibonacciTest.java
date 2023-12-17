package edu.hw11.Task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciTest {
    @Test
    @DisplayName("проверка правильного вычисления чисел фибоначи")
    void test_create_fibonacci_class() throws Exception {
        FibonacciGenerator fibonacсiGenerator = new FibonacciGenerator();
        Class<?> fibCounter = fibonacсiGenerator.generateFibonacciClass();

        Method fibonacciCalculate = fibCounter.getMethod("calculateFibonacci", int.class);
        assertThat(fibonacciCalculate.invoke(null, 5)).isEqualTo(5L);
        assertThat(fibonacciCalculate.invoke(null, 8)).isEqualTo(21L);
        assertThat(fibonacciCalculate.invoke(null, -1)).isEqualTo(0L);
    }

    @Test
    @DisplayName("Метод должен выбрасывать исключение если входные данные не int")
    void throws_exception_if_input_data_is_not_int() throws Exception {
        FibonacciGenerator fibonacсiGenerator = new FibonacciGenerator();
        Class<?> fibCounter = fibonacсiGenerator.generateFibonacciClass();
        Method fibonacciCalculate = fibCounter.getMethod("calculateFibonacci", int.class);

        assertThrows(IllegalArgumentException.class, () -> fibonacciCalculate.invoke(null, 2.8));
        assertThrows(IllegalArgumentException.class, () -> fibonacciCalculate.invoke(null, 5L));
    }
}
