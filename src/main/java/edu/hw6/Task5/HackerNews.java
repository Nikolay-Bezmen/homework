package edu.hw6.Task5;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("HideUtilityClassConstructor")
public class HackerNews {
    public static HttpClient client = HttpClient.newHttpClient();

    public static long[] hackerNewsTopStories() {
        URI uri = URI.create("https://hacker-news.firebaseio.com/v0/topstories.json");
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            body = body.substring(1, body.length() - 1);

            return Arrays.stream(body.split(","))
                .mapToLong(Long::parseLong)
                .toArray();
        } catch (IOException | InterruptedException e) {
            return new long[0];
        }
    }

    public static String news(long id) {
        URI uri = URI.create(String.format("https://hacker-news.firebaseio.com/v0/item/%d.json", id));
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String regex = "\"title\": ?\"((.|(\"(.*?)\"))*?)\",";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(response.body());
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (IOException | InterruptedException ignored) {
        }

        return "";
    }
}
