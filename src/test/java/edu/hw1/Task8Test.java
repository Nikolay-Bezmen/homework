package edu.hw1;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Task8Test {
    @Nested
    class TestedOurFunction {
        @Test
        void TestIsTrue() {
            assertThat(Task8.knightBoardCapture(new int[][]{
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
                () -> assertThat(Task8.knightBoardCapture(new int[][]{
                    {1, 0, 1, 0, 1, 0, 1, 0},
                    {0, 1, 0, 1, 0, 1, 0, 1},
                    {0, 0, 0, 0, 1, 0, 1, 0},
                    {0, 0, 1, 0, 0, 1, 0, 1},
                    {1, 0, 0, 0, 1, 0, 1, 0},
                    {0, 0, 0, 0, 0, 1, 0, 1},
                    {1, 0, 0, 0, 1, 0, 1, 0},
                    {0, 0, 0, 1, 0, 1, 0, 1}
                })).isFalse(),
                () -> assertThat(Task8.knightBoardCapture(new int[][]{
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
                    () -> assertThat(Task8.isValid(-1, 2, 3)).isFalse(),
                    () -> assertThat(Task8.isValid(1, -1, 3)).isFalse(),
                    () -> assertThat(Task8.isValid(-1, -1, 3)).isFalse(),
                    () -> assertThat(Task8.isValid(1, 3, 3)).isFalse(),
                    () -> assertThat(Task8.isValid(3, 1, 3)).isFalse()
                );
            }

            @Test
            void TestIfIsValid() {
                assertAll(
                    () -> assertThat(Task8.isValid(1, 2, 3)).isTrue(),
                    () -> assertThat(Task8.isValid(8, 4, 15)).isTrue()
                );
            }
        }
    }
}
