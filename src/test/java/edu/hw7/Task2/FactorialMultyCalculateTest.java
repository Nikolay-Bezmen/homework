package edu.hw7.Task2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FactorialMultyCalculateTest {
    @ParameterizedTest
    @MethodSource("getCorrectNumbers")
    void test_multy_factorial_calculate(int n, long correctResult){
        long resultOfCalculate = FactorialMultyCalculate.calculateFactorial(n);

        assertThat(resultOfCalculate).isEqualTo(correctResult);
    }

    private static Stream<Arguments> getCorrectNumbers(){
        return Stream.of(
            Arguments.of(0, 1),
            Arguments.of(1, 1),
            Arguments.of(2, 2),
            Arguments.of(3, 6),
            Arguments.of(4, 24),
            Arguments.of(5, 120),
            Arguments.of(8, 40320),
            Arguments.of(15, 1307674368000L),
            Arguments.of(19, 121645100408832000L),
            Arguments.of(20, 2432902008176640000L)
            );
    }
}
