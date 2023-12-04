package edu.hw9;

@SuppressWarnings("EqualsHashCode")
public record MetricStats(String metricName, double sum, double average, double min, double max) {
    private static final double EPS = 0.00000000001;

    @Override
    public String toString() {
        return "{"
            + "metricName='" + metricName + '\''
            + ", sum=" + sum
            + ", average=" + average
            + ", min=" + min + ", max=" + max + '}';
    }

    @Override
    public boolean equals(Object obj) {
        MetricStats ms = (MetricStats) obj;
        boolean metricNameIsEquals = metricName.equals(ms.metricName());
        boolean sumIsEquals = Math.abs(sum - ms.sum()) < EPS;
        boolean averageIsEquals = Math.abs(average - ms.average()) < EPS;
        boolean minIsEquals = Math.abs(min - ms.min()) < EPS;
        boolean maxIsEquals = Math.abs(max - ms.max()) < EPS;

        return metricNameIsEquals && sumIsEquals && averageIsEquals && minIsEquals && maxIsEquals;
    }
}
