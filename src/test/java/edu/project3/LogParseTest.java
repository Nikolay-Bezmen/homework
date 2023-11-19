package edu.project3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;
import static edu.project3.LogParse.INCORRECT_RECORD;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogParseTest {
    @Test
    void test_on_get_correct_date_after_parsing_process(){
        List<String> logs = List.of(
            "93.180.71.3 - - [17/May/2015:08:05:32 +0000] \"GET " +
                "/downloads/product_1 HTTP/1.1\" 304 0 \"-\" \"Debian " +
                "APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"",
            "80.91.33.133 - - [04/Jun/2015:07:06:48 +0000] \"GET " +
                "/downloads/product_1 HTTP/1.1\" 304 0 \"-\" " +
                "\"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.16)\""
        );
        List<LogRecord> correctResultOfParsingProcess = List.of(
            new LogRecord("93.180.71.3", "-",
                LocalDateTime.of(2015, 5,17,8,5,32),
                "GET /downloads/product_1 HTTP/1.1", 304, 0, "-",
                "Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)"
                ),
            new LogRecord("80.91.33.133", "-",
                LocalDateTime.of(2015, 6,4,7,6,48),
                "GET /downloads/product_1 HTTP/1.1", 304, 0, "-",
                "Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.16)"
        )
        );

        List<LogRecord> resultParsing = LogParse.parseListLogRecords(logs);

        assertThat(resultParsing).isEqualTo(correctResultOfParsingProcess);
    }

    @Test
    void test_not_throws(){
        List<String> logs = List.of(
            "205.157.110.11 - - [26/May/2015:08:05:54 +0000] \"GET " +
                "/downloads/product_2 HTTP/1.1\" 304 0 \"-\" " +
                "\"Debian APT-HTTP/1.3 (1.0.1ubuntu2)\"",
            "217.122.117.191 - - [02/Jun/2015:12:06:39 +0000] \"GET " +
                "/downloads/product_2 HTTP/1.1\" 404 336 \"-\" " +
                "\"Debian APT-HTTP/1.3 (0.9.9.1~ubuntu1)\""
        );

        assertDoesNotThrow(() -> LogParse.parseListLogRecords(logs));
    }

    @ParameterizedTest
    @MethodSource("getIncorrectPatternLogs")
    void test_throws_if_logs_is_not_suitable_for_pattern(List<String> logs){
        var exception = assertThrows(IllegalArgumentException.class,
            () -> LogParse.parseListLogRecords(logs));

        assertThat(exception.getMessage()).isEqualTo(INCORRECT_RECORD);

    }

    private static Stream<Arguments> getIncorrectPatternLogs(){
        return Stream.of(
            Arguments.of(List.of(
                "93.180.71.3 - - 17/May/2015:08:05:32 +0000] \"GET " +
                    "/downloads/product_1 HTTP/1.1\" 304 0 \"-\" \"Debian " +
                    "APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"")),
            Arguments.of(List.of(
                "80.91.33.133 - [04/Jun/2015:07:06:48 +0000] \"GET " +
                    "/downloads/product_1 HTTP/1.1\" 304 0 \"-\" " +
                    "\"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.16)\"")),
            Arguments.of(List.of(
                "93.180.71.3 - - [17/May/2015:08:05:32 +0000] \"GET " +
                    "/downloads/product_1 HTTP/1.1 304 0 \"-\" \"Debian " +
                    "APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"")),
            Arguments.of(List.of(
                "80.91.33.133 - [04/Jun/2015:07:06:48 +0000] \"GET " +
                    "/downloads/product_1 HTTP/1.1\" 304 \"-\" " +
                    "\"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.16)\""))
        );
    }
}
