package edu.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static edu.hw1.Task7.INCORRECT_SHIFT_FORMAT;
import static edu.hw1.Task7.NUMBER_SHOULD_BE_POSSIBLE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task7Test {
    Task7 task;

    @BeforeEach
    void inicialize() {
        task = new Task7();
    }

    @ParameterizedTest
    @CsvSource({
        "16,1,1", "16,364,8", "17,3,12", "28,1,25", "28,2,19"
    })
    void test_left_shift(int number, int shift, int correctCyclicShift) {
        assertThat(task.rotateLeft(number, shift)).isEqualTo(correctCyclicShift);
    }

    //1000
    @ParameterizedTest
    @CsvSource({
        "8,1,4", "28,4,25", "28,3,19", "101,4,46", "101,6,75"
    })
    void test_right_shift(int number, int shift, int correctCyclicShift) {
        assertThat(task.rotateRight(number, shift)).isEqualTo(correctCyclicShift);
    }

    @Test
    void throw_if_shift_less_then_zero() {
        assertAll(
            () -> {
                var except = assertThrows(IllegalArgumentException.class, () -> task.rotateRight(999, -1));
                assertThat(except.getMessage()).isEqualTo(INCORRECT_SHIFT_FORMAT);
            },
            () -> {
                var except = assertThrows(IllegalArgumentException.class, () -> task.rotateLeft(999, -1));
                assertThat(except.getMessage()).isEqualTo(INCORRECT_SHIFT_FORMAT);
            }
        );
    }

    @Test
    void throw_if_number_is_not_possible() {
        assertAll(
            () -> {
                var except = assertThrows(IllegalArgumentException.class, () -> task.rotateRight(-3525, 23));
                assertThat(except.getMessage()).isEqualTo(NUMBER_SHOULD_BE_POSSIBLE);
            },
            () -> {
                var except = assertThrows(IllegalArgumentException.class, () -> task.rotateLeft(-2, 41));
                assertThat(except.getMessage()).isEqualTo(NUMBER_SHOULD_BE_POSSIBLE);
            }
        );
    }
}
