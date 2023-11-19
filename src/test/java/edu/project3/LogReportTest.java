package edu.project3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.time.LocalDate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LogReportTest {
    static LogAnalysis analysis;
    static LogReport report;
    @BeforeAll static void setup() throws IOException {
        LocalDate from = LocalDate.of(2015,5,20);
        LocalDate to =  LocalDate.of(2015,6,3);
        String patternFile = "markdown";
        String pathToLogFile = "./src/main/java/edu/project3/Storage/logs.txt";
        analysis = new LogAnalysis(from, to, patternFile, null, pathToLogFile);
        analysis.inicializeListLogRecords();

        report = new LogReport(analysis);
    }
    @Test
    void test_average_size() {
        Double average = report.averageSizeOfResponse();
        int intAverage = (int) (average - (average % 1));

        int correctSize = 84;
        assertThat(intAverage).isEqualTo(correctSize);
    }

    @Test
    void test_more_heaviest_day(){
        var day = report.getDayWithMoreRequests();

        LocalDate correctDay = LocalDate.of(2015, 5, 26);

        assertThat(day.getKey()).isEqualTo(correctDay);
    }
}
