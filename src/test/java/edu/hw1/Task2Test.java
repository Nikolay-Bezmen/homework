package edu.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Task2Test {
    Task2 task;

    @BeforeEach
    void Inicialize() {
        task = new Task2();
    }

    @Test
    void TestOnValidExamples() {
        assertAll(
            () -> assertThat(task.countDigits(4666)).isEqualTo(4),
            () -> assertThat(task.countDigits(0)).isEqualTo(1),
            () -> assertThat(task.countDigits(199)).isEqualTo(3),
            () -> assertThat(task.countDigits(9)).isEqualTo(1),
            () -> assertThat(task.countDigits(18)).isEqualTo(2)
        );
    }

    @Test
    void TestIfNumberNonPositive() {
        assertAll(
            () -> assertThat(task.countDigits(-1)).isEqualTo(1),
            () -> assertThat(task.countDigits(-18392)).isEqualTo(5),
            () -> assertThat(task.countDigits(-128)).isEqualTo(3)
        );
    }
}
