package edu.project3;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HttpAnswersTest {

    @Test
    void test_some_http_code_answers(){
        HttpAnswersMap httpAnswersMap = new HttpAnswersMap();

        assertThat(httpAnswersMap.getMessageFromCode(404)).isEqualTo("Not Found");
    }

    @Test
    void test_if_code_is_not_correct(){
        HttpAnswersMap httpAnswersMap = new HttpAnswersMap();

        assertThat(httpAnswersMap.getMessageFromCode(-8)).isNull();
    }
}
