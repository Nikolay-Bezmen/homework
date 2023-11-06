package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.hw5.Task5.checkOnValidMachineNumber;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {

    @ParameterizedTest
    @MethodSource("getValidMachineNumbers")
    void check_valid_numbers(String number) {
        boolean resultCheckOnValid = checkOnValidMachineNumber(number);

        assertThat(resultCheckOnValid).isTrue();
    }

    private static Stream<Arguments> getValidMachineNumbers() {
        return Stream.of(
            Arguments.of("A123BE777"),
            Arguments.of("O777OO177"),
            Arguments.of("M024DW011"),
            Arguments.of("K746VH752"),
            Arguments.of("L987JH305")
        );
    }

    @ParameterizedTest
    @MethodSource("getInvalidMachineNumbers")
    void check_invalid_numbers(String number) {
        boolean resultCheckOnValid = checkOnValidMachineNumber(number);

        assertThat(resultCheckOnValid).isFalse();
    }

    private static Stream<Arguments> getInvalidMachineNumbers() {
        return Stream.of(
            Arguments.of("A123BE7770"),
            Arguments.of("OO77OO177"),
            Arguments.of("M0024DW011"),
            Arguments.of("KL746VH752"),
            Arguments.of("L987JSH305"),
            Arguments.of("L987JH30"),
            Arguments.of("987JH305"),
            Arguments.of("L987H305"),
            Arguments.of("L97JH305")

        );
    }
}
