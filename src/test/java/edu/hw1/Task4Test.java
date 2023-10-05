package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    @Test
    void Test1() {
        assertThat(Task4.fixString("123456")).isEqualTo("214365");
    }

    @Test
    void Test2() {
        assertThat(Task4.fixString("hTsii  s aimex dpus rtni.g")).isEqualTo("This is a mixed up string.");
    }

    @Test
    void Test3() {
        assertThat(Task4.fixString("badce")).isEqualTo("abcde");
    }

    @Test
    void Test4() {
        assertThat(Task4.fixString("1234567")).isEqualTo("2143657");
    }
}
