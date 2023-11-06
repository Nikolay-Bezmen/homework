package edu.hw5;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.hw5.Task8.task1;
import static edu.hw5.Task8.task2;
import static edu.hw5.Task8.task3;
import static edu.hw5.Task8.task4;
import static edu.hw5.Task8.task5;
import static edu.hw5.Task8.task6;
import static edu.hw5.Task8.task7;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {
    @Nested class task1Test {
        @ParameterizedTest
        @MethodSource("getValidLines")
        void check_valid_lines(String line) {
            boolean resultOfCheck = task1(line);

            assertThat(resultOfCheck).isTrue();
        }

        private static Stream<Arguments> getValidLines() {
            return Stream.of(
                Arguments.of("000"),
                Arguments.of("0"),
                Arguments.of("01010")
            );
        }

        @ParameterizedTest
        @MethodSource("getInvalidLines")
        void check_invalid_lines(String line) {
            boolean resultOfCheck = task1(line);

            assertThat(resultOfCheck).isFalse();
        }

        private static Stream<Arguments> getInvalidLines() {
            return Stream.of(
                Arguments.of("00"),
                Arguments.of(""),
                Arguments.of("0101")
            );
        }
    }

    @Nested class task2Test {
        @ParameterizedTest
        @MethodSource("getValidLines")
        void check_valid_lines(String line) {
            boolean resultOfCheck = task2(line);

            assertThat(resultOfCheck).isTrue();
        }

        private static Stream<Arguments> getValidLines() {
            return Stream.of(
                Arguments.of("0"),
                Arguments.of("0101010"),
                Arguments.of("11"),
                Arguments.of("1101"),
                Arguments.of("100001")
            );
        }

        @ParameterizedTest
        @MethodSource("getInvalidLines")
        void check_invalid_lines(String line) {
            boolean resultOfCheck = task2(line);

            assertThat(resultOfCheck).isFalse();
        }

        private static Stream<Arguments> getInvalidLines() {
            return Stream.of(
                Arguments.of("00"),
                Arguments.of("010101"),
                Arguments.of("1"),
                Arguments.of("110")
            );
        }
    }

    @Nested class task3Test {
        @ParameterizedTest
        @MethodSource("getValidLines")
        void check_valid_lines(String line) {
            boolean resultOfCheck = task3(line);

            assertThat(resultOfCheck).isTrue();
        }

        private static Stream<Arguments> getValidLines() {
            return Stream.of(
                Arguments.of("000"),
                Arguments.of(""),
                Arguments.of("010100")
            );
        }

        @ParameterizedTest
        @MethodSource("getInvalidLines")
        void check_invalid_lines(String line) {
            boolean resultOfCheck = task3(line);

            assertThat(resultOfCheck).isFalse();
        }

        private static Stream<Arguments> getInvalidLines() {
            return Stream.of(
                Arguments.of("0010"),
                Arguments.of("1"),
                Arguments.of("0101110")
            );
        }
    }

    @Nested class task4Test {
        @ParameterizedTest
        @MethodSource("getValidLines")
        void check_valid_lines(String line) {
            boolean resultOfCheck = task4(line);

            assertThat(resultOfCheck).isTrue();
        }

        private static Stream<Arguments> getValidLines() {
            return Stream.of(
                Arguments.of("11011"),
                Arguments.of("101"),
                Arguments.of("")
            );
        }

        @ParameterizedTest
        @MethodSource("getInvalidLines")
        void check_invalid_lines(String line) {
            boolean resultOfCheck = task4(line);

            assertThat(resultOfCheck).isFalse();
        }

        private static Stream<Arguments> getInvalidLines() {
            return Stream.of(
                Arguments.of("11"),
                Arguments.of("111")
            );
        }
    }

    @Nested class task5Test {
        @ParameterizedTest
        @MethodSource("getValidLines")
        void check_valid_lines(String line) {
            boolean resultOfCheck = task5(line);

            assertThat(resultOfCheck).isTrue();
        }

        private static Stream<Arguments> getValidLines() {
            return Stream.of(
                Arguments.of("101"),
                Arguments.of("1"),
                Arguments.of("1010101")
            );
        }

        @ParameterizedTest
        @MethodSource("getInvalidLines")
        void check_invalid_lines(String line) {
            boolean resultOfCheck = task5(line);

            assertThat(resultOfCheck).isFalse();
        }

        private static Stream<Arguments> getInvalidLines() {
            return Stream.of(
                Arguments.of("0101"),
                Arguments.of("0")
            );
        }
    }

    @Nested class task6Test {
        @ParameterizedTest
        @MethodSource("getValidLines")
        void check_valid_lines(String line) {
            boolean resultOfCheck = task6(line);

            assertThat(resultOfCheck).isTrue();
        }

        private static Stream<Arguments> getValidLines() {
            return Stream.of(
                Arguments.of("001"),
                Arguments.of("00000000000"),
                Arguments.of("000000001000000"),
                Arguments.of("1000000000"),
                Arguments.of("01000000000"),
                Arguments.of("0010000000000"),
                Arguments.of("000000000000")
            );
        }

        @ParameterizedTest
        @MethodSource("getInvalidLines")
        void check_invalid_lines(String line) {
            boolean resultOfCheck = task6(line);

            assertThat(resultOfCheck).isFalse();
        }

        private static Stream<Arguments> getInvalidLines() {
            return Stream.of(
                Arguments.of("0"),
                Arguments.of("0010000010000"),
                Arguments.of("1100000000"),
                Arguments.of("10111")
            );
        }
    }

    @Nested class task7Test {
        @ParameterizedTest
        @MethodSource("getValidLines")
        void check_valid_lines(String line) {
            boolean resultOfCheck = task7(line);

            assertThat(resultOfCheck).isTrue();
        }

        private static Stream<Arguments> getValidLines() {
            return Stream.of(
                Arguments.of("001000"),
                Arguments.of("00"),
                Arguments.of("1000")
            );
        }

        @ParameterizedTest
        @MethodSource("getInvalidLines")
        void check_invalid_lines(String line) {
            boolean resultOfCheck = task7(line);

            assertThat(resultOfCheck).isFalse();
        }

        private static Stream<Arguments> getInvalidLines() {
            return Stream.of(
                Arguments.of("0110"),
                Arguments.of("11"),
                Arguments.of("010100000011000")
            );
        }
    }
}
