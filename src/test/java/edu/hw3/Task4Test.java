package edu.hw3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.hw3.Task4.INCORRECT_NUMBER;
import static edu.hw3.Task4.convertToRoman;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task4Test {
    @ParameterizedTest
    @MethodSource("getArabskieNumbers")
    void check_correct_convert(int number, String romanNumber) {
        String romanResult = convertToRoman(number);

        assertThat(romanResult).isEqualTo(romanNumber);
    }

    private static Stream<Arguments> getArabskieNumbers() {
        return Stream.of(
            Arguments.of(2, "II"),
            Arguments.of(12, "XII"),
            Arguments.of(16, "XVI"),
            Arguments.of(3, "III"),
            Arguments.of(58, "LVIII"),
            Arguments.of(1994, "MCMXCIV"),
            Arguments.of(0, "")
        );
    }

    @ParameterizedTest
    @MethodSource("getIncrorrectNumbers")
    void throws_if_incorrect_number(int number) {
        var except = assertThrows(IllegalArgumentException.class, () -> convertToRoman(number));

        assertThat(except.getMessage()).isEqualTo(INCORRECT_NUMBER);
    }

    private static Stream<Arguments> getIncrorrectNumbers() {
        return Stream.of(
            Arguments.of(4000),
            Arguments.of(353531),
            Arguments.of(-1),
            Arguments.of(-4353095)
        );
    }
}
