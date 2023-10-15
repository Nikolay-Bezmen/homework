package edu.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static edu.hw1.Task8.INVALID_BOARD_PASSED;
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task8Test {
    Task8 task;

    @BeforeEach
    void inicialize() {
        task = new Task8();
    }

    @Test
    void test_is_true() throws IOException {
        assertThat(task.knightBoardCapture(new int[][] {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        })).isTrue();
    }

    @Test
    void test_is_false() {
        assertAll(
            () -> assertThat(task.knightBoardCapture(new int[][] {
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 1}
            })).isFalse(),
            () -> assertThat(task.knightBoardCapture(new int[][] {
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}
            })).isFalse()
        );
    }

    @ParameterizedTest
    @CsvSource({
        "-1,2,3", "1,-1,3", "-1,-1,3", "1,3,3", "3,1,3"
    })
    void test_if_is_not_valid(int x, int y, int n) {
        assertThat(task.isValid(x, y, n)).isFalse();
    }

    @ParameterizedTest
    @CsvSource({
        "1,2,3", "8,4,15"
    })
    void test_if_is_valid(int x, int y, int n) {
        assertThat(task.isValid(x, y, n)).isTrue();
    }

    @Test
    void throw_if_array_is_null_or_his_length_is_not_correct() {
        var expect = assertThrows(IOException.class, () -> task.knightBoardCapture(new int[][] {
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0}
        }));
        assertThat(expect.getMessage()).isEqualTo(INVALID_BOARD_PASSED);

    }
}
