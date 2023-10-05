package edu.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    Task4 task;

    @BeforeEach
    void Inicialize() {
        task = new Task4();
    }

    @Test
    void Test1() {
        assertThat(task.fixString("123456")).isEqualTo("214365");
    }

    @Test
    void Test2() {
        assertThat(task.fixString("hTsii  s aimex dpus rtni.g")).isEqualTo("This is a mixed up string.");
    }

    @Test
    void Test3() {
        assertThat(task.fixString("badce")).isEqualTo("abcde");
    }

    @Test
    void Test4() {
        assertThat(task.fixString("1234567")).isEqualTo("2143657");
    }
}
