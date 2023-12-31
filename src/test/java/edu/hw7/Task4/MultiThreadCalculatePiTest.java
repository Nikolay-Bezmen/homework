package edu.hw7.Task4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MultiThreadCalculatePiTest {
    private static final long COUNT_SIMULATION = 1_000_000_000L;
    private static final long COUNT_SIMULATION_FOR_COMPARE_SPEED = 10_000_000;
    private static final int COUNT_THREADS = 8;
    static MultiThreadCalculatingPi PI_CALCULATOR;
    @BeforeEach void setup(){
        PI_CALCULATOR = new MultiThreadCalculatingPi();
    }

    @Test
    void test_that_if_simulation_strives_to_inf_then_delta_strives_to_zero(){
        double myPi = PI_CALCULATOR.getPi(COUNT_SIMULATION, COUNT_THREADS);
        double correctPi = Math.PI;

        double myDelta = Math.abs(correctPi - myPi);
        double correctDelta = 0.05;

        assertThat(myDelta).isLessThan(correctDelta);
    }


    @Disabled
    @Test
    void test_that_single_threads_slowly_than_multi_threads(){
        long timeWhenCalculateWithSingleThread = System.currentTimeMillis();
        new SingleThreadCalculatingPi().getPi(COUNT_SIMULATION_FOR_COMPARE_SPEED);
        timeWhenCalculateWithSingleThread = System.currentTimeMillis() - timeWhenCalculateWithSingleThread;

        long timeWhenCalculateWithMultiThread = System.currentTimeMillis();
        PI_CALCULATOR.getPi(COUNT_SIMULATION_FOR_COMPARE_SPEED, COUNT_THREADS);
        timeWhenCalculateWithMultiThread = System.currentTimeMillis() - timeWhenCalculateWithMultiThread;

        assertThat(timeWhenCalculateWithMultiThread).isLessThan(timeWhenCalculateWithSingleThread);
    }
}
