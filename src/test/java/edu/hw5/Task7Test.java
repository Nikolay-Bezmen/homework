package edu.hw5;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.hw5.Task7.task1;
import static edu.hw5.Task7.task2;
import static edu.hw5.Task7.task3;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {

    @Nested class firstTaskTest {
        @ParameterizedTest
        @MethodSource("getValidLines")
        void check_if_valid_line(String line) {
            boolean resultOfCheck = task1(line);

            assertThat(resultOfCheck).isTrue();
        }

        private static Stream<Arguments> getValidLines() {
            return Stream.of(
                Arguments.of("000"),
                Arguments.of("000100")
            );
        }

        @ParameterizedTest
        @MethodSource("getInvalidLines")
        void check_if_invalid_line(String line) {
            boolean resultOfCheck = task1(line);

            assertThat(resultOfCheck).isFalse();
        }

        private static Stream<Arguments> getInvalidLines() {
            return Stream.of(
                Arguments.of("01"),
                Arguments.of("0010001010"),
                Arguments.of(" 00"),
                Arguments.of("@00"),
                Arguments.of("j00erv"),
                Arguments.of("hg0knon3")
            );
        }
    }

    @Nested class secondTaskTest {
        @ParameterizedTest
        @MethodSource("getValidLines")
        void check_if_valid_line(String line) {
            boolean resultOfCheck = task2(line);

            assertThat(resultOfCheck).isTrue();
        }

        private static Stream<Arguments> getValidLines() {
            return Stream.of(
                Arguments.of("0"),
                Arguments.of("1"),
                Arguments.of("010"),
                Arguments.of("101"),
                Arguments.of("100000000101"),
                Arguments.of("010001010")
            );
        }

        @ParameterizedTest
        @MethodSource("getInvalidLines")
        void check_if_invalid_line(String line) {
            boolean resultOfCheck = task2(line);

            assertThat(resultOfCheck).isFalse();
        }

        private static Stream<Arguments> getInvalidLines() {
            return Stream.of(
                Arguments.of("01"),
                Arguments.of("10"),
                Arguments.of("011"),
                Arguments.of("100"),
                Arguments.of("10000000010"),
                Arguments.of("01000101"),
                Arguments.of("")
            );
        }
    }

    @Nested class thirdTaskTest {
        @ParameterizedTest
        @MethodSource("getValidLines")
        void check_if_valid_lines(String line) {
            boolean resultOfCheck = task3(line);

            assertThat(resultOfCheck).isTrue();
        }

        private static Stream<Arguments> getValidLines() {
            return Stream.of(
                Arguments.of("1"),
                Arguments.of("10"),
                Arguments.of("100")
            );
        }

        @ParameterizedTest
        @MethodSource("getInvalidLines")
        void check_if_invalid_lines(String line) {
            boolean resultOfCheck = task3(line);

            assertThat(resultOfCheck).isFalse();
        }

        private static Stream<Arguments> getInvalidLines() {
            return Stream.of(
                Arguments.of(""),
                Arguments.of("1011")
            );
        }
    }
}
