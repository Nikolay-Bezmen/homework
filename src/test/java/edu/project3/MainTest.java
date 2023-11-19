package edu.project3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MainTest {
    @Test
    void test_main_work() {
        String[] ARGS = ("-jar nginx-log-stats.jar --path " +
            "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs " +
            "--from 2010-11-19 --format markdown").split(" ");
        assertDoesNotThrow(() -> Main.main(ARGS));
    }
}
