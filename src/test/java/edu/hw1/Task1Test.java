package edu.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.IOException;
import static edu.hw1.Task1.SYMBOL_IS_NOT_DIGIT;
import static edu.hw1.Task1.INCORRECT_INPUT;
import static edu.hw1.Task1.INCORRECT_DIGIT_IN_INPUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task1Test {
    Task1 task;

    @BeforeEach
    void inicialize() {
        task = new Task1();
    }

    @ParameterizedTest
    @CsvSource(
        {"01:00,60",
            "13:56,836", "9999:59,599_999", "0:00,0", "78148:13,4_688_893", "99:01,5941"
        }
    )
    void test_on_valid_examples(String timeInMinutesAndSeconds, int timeInSeconds) throws IOException {
        assertThat(task.minutesToSeconds(timeInMinutesAndSeconds)).isEqualTo(timeInSeconds);
    }

    @Test
    void fail_if_second_more_then_one_minute() throws IOException {
        assertThat(task.minutesToSeconds("01:60")).isEqualTo(-1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"00:0", "00:000", "00"})
    void throw_exception_if_incorrect_form(String time) {
        var except = assertThrows(IOException.class, () -> task.minutesToSeconds(time));
        assertThat(except.getMessage()).isEqualTo(INCORRECT_INPUT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"00:0a", "00d:01"})
    void throw_exception_if_unknown_form(String time) {
        var except = assertThrows(IOException.class, () -> task.minutesToSeconds(time));
        assertThat(except.getMessage()).isEqualTo(SYMBOL_IS_NOT_DIGIT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"35791394:50", "35791399:01"})
    void throw_exception_if_out_of_range(String time) {
        var except = assertThrows(IOException.class, () -> task.minutesToSeconds(time));
        assertThat(except.getMessage()).isEqualTo(INCORRECT_DIGIT_IN_INPUT);
    }
}
