package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Task2Test {
    @Test
    void TestOnValidExamples() {
        assertAll(
            () -> assertThat(Task2.countDigits(4666)).isEqualTo(4),
            () -> assertThat(Task2.countDigits(0)).isEqualTo(1),
            () -> assertThat(Task2.countDigits(199)).isEqualTo(3),
            () -> assertThat(Task2.countDigits(9)).isEqualTo(1),
            () -> assertThat(Task2.countDigits(18)).isEqualTo(2)
        );
    }

    @Test
    void TestIfNumberNonPositive() {
        assertAll(
            () -> assertThat(Task2.countDigits(-1)).isEqualTo(1),
            () -> assertThat(Task2.countDigits(-18392)).isEqualTo(5),
            () -> assertThat(Task2.countDigits(-128)).isEqualTo(3)
        );
    }
}
