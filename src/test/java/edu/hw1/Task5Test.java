package edu.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Task5Test {
    Task5 task;

    @BeforeEach
    void Inicialize() {
        task = new Task5();
    }

    @Nested
    class TestMainFunction {
        @Test
        void TestIfIsPalindromeDescendantReturnTrue() {
            assertAll(
                () -> assertThat(task.isPalindromeDescendant(11211230)).isTrue(),
                () -> assertThat(task.isPalindromeDescendant(13001120)).isTrue(),
                () -> assertThat(task.isPalindromeDescendant(23336014)).isTrue(),
                () -> assertThat(task.isPalindromeDescendant(11)).isTrue()
            );
        }
        //11 21 12 30 -> 23 33 -> 56 -> 11 -> true
        //13 00 11 20 -> 40 22 -> 44 -> true
        //23 33 60 14 -> 56 65 -> true
        //11 -> true

        @Test
        void TestIfIsNotPalindromeDescendant() {
            assertAll(
                () -> assertThat(task.isPalindromeDescendant(1234)).isFalse(),
                () -> assertThat(task.isPalindromeDescendant(666655)).isFalse(),
                () -> assertThat(task.isPalindromeDescendant(129865891)).isFalse(),
                () -> assertThat(task.isPalindromeDescendant(92480921)).isFalse()
            );
        }
        //12 34 -> 37 -> false
        //66 66 55 -> 12 12 10 -> 33 1 -> 61 -> false
        //12 98 65 89 1 -> 31 71 11 71 -> 48 28 -> 12 10 -> 31 -> false
        //92 48 09 21 -> 11 12 93 -> 23 11 -> 52 -> false

    }

    @Nested
    class TestPalindrome {
        @Test
        void TestIfIsPalindrome() {
            assertAll(
                () -> assertThat(task.isPalindrome("111")).isTrue(),
                () -> assertThat(task.isPalindrome("1111")).isTrue(),
                () -> assertThat(task.isPalindrome("12321")).isTrue(),
                () -> assertThat(task.isPalindrome("3415143")).isTrue(),
                () -> assertThat(task.isPalindrome("2442")).isTrue()
            );
        }

        @Test
        void TestIfIsNotPalindrome() {
            assertAll(
                () -> assertThat(task.isPalindrome("1114")).isFalse(),
                () -> assertThat(task.isPalindrome("17111")).isFalse(),
                () -> assertThat(task.isPalindrome("12361")).isFalse(),
                () -> assertThat(task.isPalindrome("3467143")).isFalse(),
                () -> assertThat(task.isPalindrome("244298")).isFalse()
            );
        }
    }
}
