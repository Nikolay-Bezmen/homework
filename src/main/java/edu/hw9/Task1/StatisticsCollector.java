package edu.hw9.Task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StatisticsCollector {
    private final List<MetricStats> metrics = Collections.synchronizedList(new ArrayList<>());
    private final ExecutorService executerStats;

    public void push(String newMetric, double[] data) {
        executerStats.execute(() -> {
            double sum = 0;
            double min = Double.MAX_VALUE;
            double max = Double.MIN_VALUE;
            for (double value : data) {
                sum += value;
                if (value < min) {
                    min = value;
                }
                if (value > max) {
                    max = value;
                }
            }
            double average = sum / data.length;
            metrics.add(new MetricStats(newMetric, sum, average, min, max));
        });
    }

    public StatisticsCollector(int countThreads) {
        executerStats = Executors.newFixedThreadPool(countThreads);
    }

    public List<MetricStats> getStats() {
        return new ArrayList<>(metrics);
    }
}

