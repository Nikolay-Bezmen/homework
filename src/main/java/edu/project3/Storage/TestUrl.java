package edu.project3.Storage;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TestUrl {
    public static void main(String[] args) {
        URI myURI = URI.create("https://raw.githubusercontent.com/"
            + "elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(myURI).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String bodyResponse = response.body();

            String[] lines = bodyResponse.split("\n");
            int i = 0;
            for (String line : lines) {
                System.out.println(++i + ": " + line);
            }
            System.out.println(lines.length);
            System.out.println();

        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
