package edu.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {
    Task5 task;

    @BeforeEach
    void inicialize() {
        task = new Task5();
    }

    @ParameterizedTest
    @ValueSource(ints = {11211230, 13001120, 23336014, 11})
    void test_if_is_palindrome_descendant_return_true(int number) {
        assertThat(task.isPalindromeDescendant(number)).isTrue();
    }
    //11 21 12 30 -> 23 33 -> 56 -> 11 -> true
    //13 00 11 20 -> 40 22 -> 44 -> true
    //23 33 60 14 -> 56 65 -> true
    //11 -> true

    @ParameterizedTest
    @ValueSource(ints = {1234, 666655, 129865891, 92480921})
    void test_if_is_not_palindrome_descendant(int number) {
        assertThat(task.isPalindromeDescendant(number)).isFalse();
    }
    //12 34 -> 37 -> false
    //66 66 55 -> 12 12 10 -> 33 1 -> 61 -> false
    //12 98 65 89 1 -> 31 71 11 71 -> 48 28 -> 12 10 -> 31 -> false
    //92 48 09 21 -> 11 12 93 -> 23 11 -> 52 -> false

    @ParameterizedTest
    @ValueSource(strings = {"111", "1111", "12321", "3415143", "2442"})
    void test_if_is_palindrome(String number) {
        assertThat(task.isPalindrome(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1114", "17111", "12361", "3467143", "244298"})
    void test_if_is_not_palindrome(String number) {
        assertThat(task.isPalindrome(number)).isFalse();

    }
}
