package edu.hw7.Task1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MultyThreadIncrementatorTest {
    @Test
    void test_on_correct_multyply_increment_work() throws InterruptedException {
        int countIncrementOperations = 88;
        int resultOfWork = MultyThreadIncrementator.multyThreadIncrementator(countIncrementOperations);

        assertThat(resultOfWork).isEqualTo(countIncrementOperations);
    }
}
