package edu.hw1;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.hw1.Task3.ARRAY_IS_NOT_PASSED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task3Test {
    Task3 task;

    @BeforeEach
    void inicialize() {
        task = new Task3();
    }

    @ParameterizedTest
    @MethodSource("getArgumentsAndWaitTrue")
    void test_if_examples_is_valid(int[] arr1, int[] arr2) {
        assertThat(task.isNestable(arr1, arr2)).isTrue();
    }

    private static @NotNull Stream<Arguments> getArgumentsAndWaitTrue() {
        return Stream.of(
            Arguments.of(new int[] {1, 2, 3, 4}, new int[] {0, 6}),
            Arguments.of(new int[] {3, 1}, new int[] {4, 0}),
            Arguments.of(new int[] {4, 16, 13}, new int[] {3, 17}),
            Arguments.of(new int[] {1, 3, 5, 7}, new int[] {8, 0}),
            Arguments.of(new int[] {-999, 15, 999}, new int[] {5000, -5000}),
            Arguments.of(new int[] {8, 35}, new int[] {-1, 36})
        );
    }

    @ParameterizedTest
    @MethodSource("getArgumentsAndWaitFalse")
    void test_if_examples_is_not_valid(int[] arr1, int[] arr2) {
        assertThat(task.isNestable(arr1, arr2)).isFalse();
    }

    private static @NotNull Stream<Arguments> getArgumentsAndWaitFalse() {
        return Stream.of(
            Arguments.of(new int[] {9, 9, 8}, new int[] {8, 9}),
            Arguments.of(new int[] {1, 2, 3, 4}, new int[] {2, 3}),
            Arguments.of(new int[] {5, 5, 5}, new int[] {5, 5, 5, 5})
        );
    }

    @Test
    void test_if_first_array_has_zero_length() {
        assertThat(task.isNestable(new int[] {}, new int[] {0, 1})).isTrue();
    }

    @ParameterizedTest
    @MethodSource("getStrangeArguments")
    void test_if_second_array_has_length_less_then_two(int[] arr1, int[] arr2) {
        assertThat(task.isNestable(arr1, arr2)).isFalse();
    }

    static @NotNull Stream<Arguments> getStrangeArguments() {
        return Stream.of(
            Arguments.of(new int[] {0, 1}, new int[] {}),
            Arguments.of(new int[] {0, 1}, new int[] {6})
        );
    }

    @Test
    void test_if_both_array_has_length_zero() {
        assertThat(task.isNestable(new int[] {}, new int[] {})).isFalse();
    }

    @ParameterizedTest
    @MethodSource("getArgumentsForThrowException_ARRAY_IS_NOT_PASSED")
    void throw_if_array_is_null(int[] arr1, int[] arr2) {
        var except = assertThrows(NullPointerException.class, () -> task.isNestable(arr1, arr2));
        assertThat(except.getMessage()).isEqualTo(ARRAY_IS_NOT_PASSED);
    }

    private static @NotNull Stream<Arguments> getArgumentsForThrowException_ARRAY_IS_NOT_PASSED() {
        return Stream.of(
            Arguments.of(new int[] {11, 22}, null),
            Arguments.of(null, new int[] {11, 22})
        );
    }
}
