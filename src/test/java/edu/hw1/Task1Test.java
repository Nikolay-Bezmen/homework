package edu.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task1Test {
    Task1 task;

    @BeforeEach
    void Inicialize() {
        task = new Task1();
    }

    @Test
    void TestOnValidExamples() {
        assertAll(
            () -> assertThat(task.minutesToSeconds("01:00")).isEqualTo(60),
            () -> assertThat(task.minutesToSeconds("13:56")).isEqualTo(836),
            () -> assertThat(task.minutesToSeconds("01:00")).isEqualTo(60),
            () -> assertThat(task.minutesToSeconds("13:56")).isEqualTo(836),
            () -> assertThat(task.minutesToSeconds("9999:59")).isEqualTo(599_999),
            () -> assertThat(task.minutesToSeconds("0:00")).isEqualTo(0),
            () -> assertThat(task.minutesToSeconds("78148:13")).isEqualTo(4_688_893),
            () -> assertThat(task.minutesToSeconds("99:01")).isEqualTo(5941)
        );
    }

    @Test
    void FailIfSecondMoreThenOneMinute() throws IOException {
        assertThat(task.minutesToSeconds("01:60")).isEqualTo(-1);
    }

    @Test
    void throwExceptionIfUncorrectForm() {
        assertAll(
            () -> {
                var except = assertThrows(IOException.class, () -> task.minutesToSeconds("00:0"));
                assertThat(except.getMessage()).isEqualTo(task.uncorrectInput);
            },
            () -> {
                var except = assertThrows(IOException.class, () -> task.minutesToSeconds("00:000"));
                assertThat(except.getMessage()).isEqualTo(task.uncorrectInput);
            },
            () -> {
                var except = assertThrows(IOException.class, () -> task.minutesToSeconds("00"));
                assertThat(except.getMessage()).isEqualTo(task.uncorrectInput);
            }
        );
    }

    @Test
    void throwExceptionIfUnknownForm() {
        assertAll(
            () -> {
                var except = assertThrows(IOException.class, () -> task.minutesToSeconds("00:0a"));
                assertThat(except.getMessage()).isEqualTo(task.notDigitSymbol);
            },
            () -> {
                var except = assertThrows(IOException.class, () -> task.minutesToSeconds("00d:01"));
                assertThat(except.getMessage()).isEqualTo(task.notDigitSymbol);
            }
        );
    }

    @Test
    void throwExceptionIfOutOfRange() {
        assertAll(
            () -> {
                var except = assertThrows(IOException.class, () -> task.minutesToSeconds("35791394:50"));
                assertThat(except.getMessage()).isEqualTo(task.uncorrectDigitInInput);
            },
            () -> {
                var except = assertThrows(IOException.class, () -> task.minutesToSeconds("35791399:01"));
                assertThat(except.getMessage()).isEqualTo(task.uncorrectDigitInInput);
            }
        );
    }
}
