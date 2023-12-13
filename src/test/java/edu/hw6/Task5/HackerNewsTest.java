package edu.hw6.Task5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.stream.Stream;
import static edu.hw6.Task5.HackerNews.hackerNewsTopStories;
import static edu.hw6.Task5.HackerNews.news;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HackerNewsTest {
    @ParameterizedTest
    @MethodSource("getIdAndCorrectTitleForThem")
    void test_news_method(long id, String correctTitle) {
        HackerNews.client = HttpClient.newHttpClient();

        String title = news(id);

        assertThat(title).isEqualTo(correctTitle);
    }

    private static Stream<Arguments> getIdAndCorrectTitleForThem() {
        return Stream.of(
            Arguments.of(38263294, "A Lot of Damage in Grindavík"),
            Arguments.of(38255455, "Inequalities, convergence, and continuity as \\\"special deals\\\""),
            Arguments.of(
                38229998,
                "Lost \\\"Doctor Who\\\" episodes found but owner is reluctant to hand them to BBC"
            ),
            Arguments.of(38257860, "Fedora 40: Transition to Zlib-ng as compatible replacement for Zlib"),
            Arguments.of(
                38251864,
                "U.S. struck with record 25 separate billion-dollar disasters so far this year"
            ),
            Arguments.of(38244532, "Inverted Totalitarianism"),
            Arguments.of(38230494, "Master Foo and the Unix Zealot")
        );
    }

    @Test
    void test_hackerNewsTopStories() {
        long[] ids = hackerNewsTopStories();

        assertThat(ids).isNotNull();
        assertThat(ids).isNotEmpty();
    }

    @Test
    void test_correct_work_hacker_news_top_stories_with_network() throws IOException, InterruptedException {
        HttpClient client = Mockito.mock(HttpClient.class);
        HttpResponse<String> response = Mockito.mock(HttpResponse.class);

        Mockito.when(client.send(
                Mockito.any(HttpRequest.class),
                ArgumentMatchers.<HttpResponse.BodyHandler<String>>any()
            ))
            .thenReturn(response);
        Mockito.when(response.body()).thenReturn("[38263294,38261913,38250459]");

        HackerNews.client = client;

        long[] ids = hackerNewsTopStories();
        assertThat(ids).isEqualTo(new long[] {38263294, 38261913, 38250459});
    }

    @Test
    void test_correct_work_news_method_with_network() throws IOException, InterruptedException {
        HttpClient client = Mockito.mock(HttpClient.class);
        HttpResponse<String> response = Mockito.mock(HttpResponse.class);

        Mockito.when(client.send(
                Mockito.any(HttpRequest.class),
                ArgumentMatchers.<HttpResponse.BodyHandler<String>>any()
            ))
            .thenReturn(response);
        Mockito.when(response.body()).thenReturn("""
                {
                    "by": "8bitsrule",
                    "descendants": 3,
                    "id": 38244532,
                    "kids": [
                        38248612,
                        38256853
                    ],
                    "score": 8,
                    "time": 1699826429,
                    "title": "Inverted Totalitarianism",
                    "type": "story",
                    "url": "https://en.wikipedia.org/wiki/Inverted_totalitarianism"
                }""");
        HackerNews.client = client;

        String title = news(38244532);

        assertThat(title).isEqualTo("Inverted Totalitarianism");
    }

}
