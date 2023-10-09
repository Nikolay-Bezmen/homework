package edu.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    Task4 task;

    @BeforeEach
    void Inicialize() {
        task = new Task4();
    }

    @ParameterizedTest
    @CsvSource(
        {"123456,214365", "hTsii  s aimex dpus rtni.g,This is a mixed up string.",
            "badce,abcde", "1234567,2143657"}
    )
    void test_fixString(String broken, String correct) {
        assertThat(task.fixString(broken)).isEqualTo(correct);
    }
}
