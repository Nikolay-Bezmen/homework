package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {

    @Test
    void Test1() {
        assertThat(Task6.countK(6621)).isEqualTo(5);
    }

    @Test
    void Test2() {
        assertThat(Task6.countK(6554)).isEqualTo(4);
    }

    @Test
    void Test3() {
        assertThat(Task6.countK(1234)).isEqualTo(3);
    }

    @Test
    void Test4() {
        assertThat(Task6.countK(3524)).isEqualTo(3);
    }
}
