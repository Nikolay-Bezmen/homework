package edu.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    Task2 task;

    @BeforeEach
    void inicialize() {
        task = new Task2();
    }

    @ParameterizedTest
    @CsvSource({
        "4666,4", "0,1", "199,3", "9,1", "18,2"
    })
    void test_on_valid_examples(int number, int countDigitInNumber) {
        assertThat(task.countDigits(number)).isEqualTo(countDigitInNumber);
    }

    @ParameterizedTest
    @CsvSource({
        "-1,1", "-18392,5", "-128,3"
    })
    void test_if_number_non_positive() {
        assertThat(task.countDigits(-128)).isEqualTo(3);
    }
}
