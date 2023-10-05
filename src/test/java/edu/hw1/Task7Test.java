package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Task7Test {
    @Test
    void TestLeftShift() {
        assertAll(
            () -> assertThat(Task7.rotateLeft(16, 1)).isEqualTo(1),
            () -> assertThat(Task7.rotateLeft(16, 364)).isEqualTo(8),
            () -> assertThat(Task7.rotateLeft(17, 3)).isEqualTo(12),
            () -> assertThat(Task7.rotateLeft(28, 1)).isEqualTo(25),
            () -> assertThat(Task7.rotateLeft(28, 2)).isEqualTo(19)
        );
    }

    @Test
    void TestRightShift() {
        assertAll(
            () -> assertThat(Task7.rotateRight(8, 1)).isEqualTo(4),
            () -> assertThat(Task7.rotateRight(28, 4)).isEqualTo(25),
            () -> assertThat(Task7.rotateRight(28, 3)).isEqualTo(19),
            () -> assertThat(Task7.rotateRight(101, 4)).isEqualTo(46),
            () -> assertThat(Task7.rotateRight(101, 6)).isEqualTo(75)
        );
    }
}
