package edu.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.IOException;
import static edu.hw1.Task6.INCORRECT_INPUT_DATA;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings("MagicNumber")
public class Task6Test {
    Task6 task;

    @BeforeEach
    void inicialize() {
        task = new Task6();
    }

    @ParameterizedTest
    @CsvSource(
        {"6621,5", "6554,4", "1234,3", "3524,3"}
    )
    void test_on_correct_work(int number, int countSteps) throws IOException {
        assertThat(task.countK(number)).isEqualTo(countSteps);
    }

    @ParameterizedTest
    @ValueSource(ints = {8888, 999, 10000})
    void throw_if_data_not_suitable(int number) {
        var except = assertThrows(IOException.class, () -> task.countK(number));
        assertThat(except.getMessage()).isEqualTo(INCORRECT_INPUT_DATA);
    }
}
