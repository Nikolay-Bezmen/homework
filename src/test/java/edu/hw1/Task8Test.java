package edu.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
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

    @Nested
    class TestedOurFunction {
        @Test
        void TestIsTrue() throws IOException {
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
        void TestIsFalse() {
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

        @Nested
        class TestHelpFunction {
            @Test
            void TestIfIsNotValid() {
                assertAll(
                    () -> assertThat(task.isValid(-1, 2, 3)).isFalse(),
                    () -> assertThat(task.isValid(1, -1, 3)).isFalse(),
                    () -> assertThat(task.isValid(-1, -1, 3)).isFalse(),
                    () -> assertThat(task.isValid(1, 3, 3)).isFalse(),
                    () -> assertThat(task.isValid(3, 1, 3)).isFalse()
                );
            }

            @Test
            void TestIfIsValid() {
                assertAll(
                    () -> assertThat(task.isValid(1, 2, 3)).isTrue(),
                    () -> assertThat(task.isValid(8, 4, 15)).isTrue()
                );
            }
        }

        @Test
        void throwIfArrayIsNullOrHisLengthIsNotCorrect() {
            var expect = assertThrows(IOException.class, () -> task.knightBoardCapture(new int[][] {
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0}
            }));
            assertThat(expect.getMessage()).isEqualTo("передана неверная доска");

        }
    }
}
