package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Task1Test {
    @Test
    void TestOnValidExamples() {
        assertAll(
            () -> assertThat(Task1.minutesToSeconds("01:00")).isEqualTo(60),
            () -> assertThat(Task1.minutesToSeconds("13:56")).isEqualTo(836),
            () -> assertThat(Task1.minutesToSeconds("01:00")).isEqualTo(60),
            () -> assertThat(Task1.minutesToSeconds("13:56")).isEqualTo(836),
            () -> assertThat(Task1.minutesToSeconds("9999:59")).isEqualTo(599_999),
            () -> assertThat(Task1.minutesToSeconds("0:00")).isEqualTo(0),
            () -> assertThat(Task1.minutesToSeconds("78148:13")).isEqualTo(4_688_893),
            () -> assertThat(Task1.minutesToSeconds("99:01")).isEqualTo(5941)
        );
    }

    @Test
    void FailIfSecondMoreThenOneMinute() {
        assertThat(Task1.minutesToSeconds("01:60")).isEqualTo(-1);
    }
}
