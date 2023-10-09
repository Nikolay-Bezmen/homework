package edu.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task3.ARRAY_IS_NOT_PASSED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task3Test {
    Task3 task;

    @BeforeEach
    void inicialize() {
        task = new Task3();
    }

    @Test
    void test_if_examples_is_valid() {
        assertAll(
            () -> assertThat(task.isNestable(new int[] {1, 2, 3, 4}, new int[] {0, 6})).isTrue(),
            () -> assertThat(task.isNestable(new int[] {3, 1}, new int[] {4, 0})).isTrue(),
            () -> assertThat(task.isNestable(new int[] {4, 16, 13}, new int[] {3, 17})).isTrue(),
            () -> assertThat(task.isNestable(new int[] {1, 3, 5, 7}, new int[] {8, 0})).isTrue(),
            () -> assertThat(task.isNestable(new int[] {-999, 15, 999}, new int[] {5000, -5000})).isTrue(),
            () -> assertThat(task.isNestable(new int[] {8, 35}, new int[] {-1, 36})).isTrue()
        );
    }

    @Test
    void test_if_examples_is_not_valid() {
        assertAll(
            () -> assertThat(task.isNestable(new int[] {9, 9, 8}, new int[] {8, 9})).isFalse(),
            () -> assertThat(task.isNestable(new int[] {1, 2, 3, 4}, new int[] {2, 3})).isFalse(),
            () -> assertThat(task.isNestable(new int[] {5, 5, 5}, new int[] {5, 5, 5, 5})).isFalse()
        );
    }

    @Test
    void test_if_first_array_has_zero_length() {
        assertThat(task.isNestable(new int[] {}, new int[] {0, 1})).isTrue();
    }

    @Test
    void test_if_second_array_has_length_less_then_two() {
        assertAll(
            () -> assertThat(task.isNestable(new int[] {0, 1}, new int[] {})).isFalse(),
            () -> assertThat(task.isNestable(new int[] {0, 1}, new int[] {6})).isFalse()
        );
    }

    @Test
    void test_if_both_array_has_length_zero() {
        assertThat(task.isNestable(new int[] {}, new int[] {})).isFalse();
    }

    @Test
    void throw_if_array_is_null() {
        assertAll(
            () -> {
                var except = assertThrows(NullPointerException.class, () -> task.isNestable(null, new int[] {11, 22}));
                assertThat(except.getMessage()).isEqualTo(ARRAY_IS_NOT_PASSED);
            },
            () -> {
                var except = assertThrows(NullPointerException.class, () -> task.isNestable(new int[] {11, 22}, null));
                assertThat(except.getMessage()).isEqualTo(ARRAY_IS_NOT_PASSED);
            }
        );
    }
}
