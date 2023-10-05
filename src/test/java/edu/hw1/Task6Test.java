package edu.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task6Test {
    Task6 task;

    @BeforeEach
    void Inicialize() {
        task = new Task6();
    }

    @Test
    void Test1() throws IOException {
        assertThat(task.countK(6621)).isEqualTo(5);
    }

    @Test
    void Test2() throws IOException {
        assertThat(task.countK(6554)).isEqualTo(4);
    }

    @Test
    void Test3() throws IOException {
        assertThat(task.countK(1234)).isEqualTo(3);
    }

    @Test
    void Test4() throws IOException {
        assertThat(task.countK(3524)).isEqualTo(3);
    }

    @Test
    void throwIfDataNotSuitable() {
        assertAll(
            () -> {
                var except = assertThrows(IOException.class, () -> task.countK(999));
                assertThat(except.getMessage()).isEqualTo("некоректные входные данные");
            },
            () -> {
                var except = assertThrows(IOException.class, () -> task.countK(8888));
                assertThat(except.getMessage()).isEqualTo("некоректные входные данные");
            },
            () -> {
                var except = assertThrows(IOException.class, () -> task.countK(10000));
                assertThat(except.getMessage()).isEqualTo("некоректные входные данные");
            }
        );
    }
}
