package edu.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task7Test {
    Task7 task;

    @BeforeEach
    void inicialize() {
        task = new Task7();
    }

    @Test
    void TestLeftShift() {
        assertAll(
            () -> assertThat(task.rotateLeft(16, 1)).isEqualTo(1),
            () -> assertThat(task.rotateLeft(16, 364)).isEqualTo(8),
            () -> assertThat(task.rotateLeft(17, 3)).isEqualTo(12),
            () -> assertThat(task.rotateLeft(28, 1)).isEqualTo(25),
            () -> assertThat(task.rotateLeft(28, 2)).isEqualTo(19)
        );
    }

    @Test
    void TestRightShift() {
        assertAll(
            () -> assertThat(task.rotateRight(8, 1)).isEqualTo(4),
            () -> assertThat(task.rotateRight(28, 4)).isEqualTo(25),
            () -> assertThat(task.rotateRight(28, 3)).isEqualTo(19),
            () -> assertThat(task.rotateRight(101, 4)).isEqualTo(46),
            () -> assertThat(task.rotateRight(101, 6)).isEqualTo(75)
        );
    }

    @Test
    void throwIfShiftLessThenZero() {
        assertAll(
            () -> {
                var except = assertThrows(IllegalArgumentException.class, () -> task.rotateRight(999, -1));
                assertThat(except.getMessage()).isEqualTo("неверный формат сдвига");
            },
            () -> {
                var except = assertThrows(IllegalArgumentException.class, () -> task.rotateLeft(999, -1));
                assertThat(except.getMessage()).isEqualTo("неверный формат сдвига");
            }
        );
    }
}
