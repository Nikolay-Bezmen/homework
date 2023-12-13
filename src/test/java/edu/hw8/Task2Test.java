package edu.hw8;

import org.junit.jupiter.api.Test;
import edu.hw8.Task2.FixedThreadPool;
import java.util.concurrent.atomic.AtomicInteger;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    void test_correct_executing_tasks_in_pool(){
        AtomicInteger atomic = new AtomicInteger(0);
        FixedThreadPool pool = FixedThreadPool.create(Runtime.getRuntime().availableProcessors());
        int correctResultSum = 5050;

        for(int i = 1; i <= 100; ++i){
            int finalI = i;
            pool.execute(() -> atomic.addAndGet(finalI));
        }
        pool.start();

        while (true){
            if(pool.smartClose()){
                break;
            }
        }
        assertThat(atomic.get()).isEqualTo(correctResultSum);
    }
}
