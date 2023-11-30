package edu.project3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(MockitoExtension.class)

public class LogAnalysisTest {
    @Test
    void test_create_correct_object() throws IOException {
        LocalDate from = LocalDate.of(2000,12,31);
        LocalDate to = null;
        String patternFile = "markdown";
        String pathToLogFile = null;
        String uri = "https://raw.githubusercontent.com/elastic/examples" +
            "/master/Common%20Data%20Formats/nginx_logs/nginx_logs";

        LogAnalysis logAnalysis = new LogAnalysis(from, to,
            patternFile,
            uri,
            null);

        assertThat(logAnalysis.getUriPath()).isEqualTo(URI.create(uri));
        assertThat(logAnalysis.getDateTo()).isEqualTo(to);
        assertThat(logAnalysis.getDateFrom()).isEqualTo(from);
        assertThat(logAnalysis.getPatternFileOutPut()).isEqualTo(patternFile);
        assertThat(logAnalysis.getPathToLogFile()).isEqualTo(pathToLogFile);
    }

    @ParameterizedTest
    @MethodSource("getLogsSources")
    void test_get_logs_from_different_sources(String pathToLogFile, String uri) throws IOException {
        LocalDate from = LocalDate.of(2000,12,31);
        LocalDate to = null;
        String patternFile = "markdown";

        LogAnalysis logAnalysis = new LogAnalysis(from, to,
            patternFile,
            uri,
            pathToLogFile);

        assertDoesNotThrow(logAnalysis::inicializeListLogRecords);
    }

    private static Stream<Arguments> getLogsSources(){
        return Stream.of(
            Arguments.of(null,"https://raw.githubusercontent.com/elastic/examples" +
            "/master/Common%20Data%20Formats/nginx_logs/nginx_logs"),
            Arguments.of("./src/main/java/edu/project3/Storage", null),
            Arguments.of("./src/main/java/edu/project3/Storage/logs.txt", null)
            );
    }
}
