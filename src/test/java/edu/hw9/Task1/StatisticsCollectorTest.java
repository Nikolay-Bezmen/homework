package edu.hw9.Task1;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import static java.lang.Thread.sleep;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StatisticsCollectorTest {
    private static final int TIME_PAUSE = 10;
    @Test
    void test_correct_statistics() throws InterruptedException {
        String metricName = "metric";
        double[] data = {2.4, 4.8, 3.6};
        double average = 3.6;
        double min = 2.4;
        double max = 4.8;
        double sum = 10.8;

        MetricStats correctStats = new MetricStats(metricName, sum, average, min, max);
        StatisticsCollector collector = new StatisticsCollector(4);
        collector.push(metricName, data);
        sleep(TIME_PAUSE);
        MetricStats resultStats = collector.getStats().get(0);


        assertThat(resultStats).isEqualTo(correctStats);
    }

    @Test
    void test_correct_statistics_in_multi_thread_process() throws InterruptedException {
        String[] metrics = {
            "metric1",
            "metric2",
            "metric3",
            "metric4"
        };

        double[][] dates = {
            {13.98, -9.47, 17.999997, 10000.7},
            {-777, 98.342, 99.1},
            {2.6, 3.8, 9.83, 18.07},
            {2, -87.6}
        };

        List<MetricStats> correctStats = List.of(
            new MetricStats(metrics[0], 10023.209997, 2505.80249925, -9.47, 10000.7),
            new MetricStats(metrics[1], -579.558, -193.186, -777.0, 99.1),
            new MetricStats(metrics[2], 34.3, 8.575, 2.6, 18.07),
            new MetricStats(metrics[3], -85.6, -42.8, -87.6, 2.0)
        );

        StatisticsCollector collector = new StatisticsCollector(4);

        Thread[] threads = new Thread[4];
        CountDownLatch latch = new CountDownLatch(threads.length);

        for (int i = 0; i < 4; ++i){
            int finalI = i;
            threads[i] = new Thread(() ->{
                latch.countDown();

                try{
                    latch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                collector.push(metrics[finalI], dates[finalI]);

                try {
                    sleep(TIME_PAUSE);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });

            threads[i].start();
        }

        for (Thread thread: threads){
            thread.join();
        }

        List<MetricStats> stats = collector.getStats();

        assertThat(stats.size()).isEqualTo(correctStats.size());
        for (MetricStats stata : stats){
            assertThat(correctStats.contains(stata)).isTrue();
        }
    }
}
