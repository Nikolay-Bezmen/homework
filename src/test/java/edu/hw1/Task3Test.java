package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Task3Test {
    @Test
    void TestIfExamplesIsValid() {
        assertAll(
            () -> assertThat(Task3.isNestable(new int[]{1, 2, 3, 4}, new int[]{0, 6})).isTrue(),
            () -> assertThat(Task3.isNestable(new int[]{3, 1}, new int[]{4, 0})).isTrue(),
            () -> assertThat(Task3.isNestable(new int[]{4, 16, 13}, new int[]{3, 17})).isTrue(),
            () -> assertThat(Task3.isNestable(new int[]{1, 3, 5, 7}, new int[]{8, 0})).isTrue(),
            () -> assertThat(Task3.isNestable(new int[]{-999, 15, 999}, new int[]{5000, -5000})).isTrue(),
            () -> assertThat(Task3.isNestable(new int[]{8, 35}, new int[]{-1, 36})).isTrue()
        );
    }

    @Test
    void TestIfExamplesIsNotValid() {
        assertAll(
            () -> assertThat(Task3.isNestable(new int[]{9, 9, 8}, new int[]{8, 9})).isFalse(),
            () -> assertThat(Task3.isNestable(new int[]{1, 2, 3, 4}, new int[]{2, 3})).isFalse(),
            () -> assertThat(Task3.isNestable(new int[]{5, 5, 5}, new int[]{5, 5, 5, 5})).isFalse()
        );
    }

    @Test
    void TestIfFirstArrayHasZeroLength() {
        assertThat(Task3.isNestable(new int[]{}, new int[]{0, 1})).isTrue();
    }

    @Test
    void TestIfSecondArrayHasLengthLessThenTwo() {
        assertAll(
            () -> assertThat(Task3.isNestable(new int[]{0, 1}, new int[]{})).isFalse(),
            () -> assertThat(Task3.isNestable(new int[]{0, 1}, new int[]{6})).isFalse()
        );
    }

    @Test
    void TestIfBothArrayHasLengthZero() {
        assertThat(Task3.isNestable(new int[]{}, new int[]{})).isFalse();
    }
}
