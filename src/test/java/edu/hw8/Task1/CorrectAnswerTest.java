package edu.hw8.Task1;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import static edu.hw8.Task1.Message.INSULTS_REQUEST;
import static edu.hw8.Task1.Message.INSULTS_RESPONSE;
import static edu.hw8.Task1.Message.INTELLIGENCE_REQUEST;
import static edu.hw8.Task1.Message.INTELLIGENCE_RESPONSE;
import static edu.hw8.Task1.Message.PERSONALITIES_REQUEST;
import static edu.hw8.Task1.Message.PERSONALITIES_RESPONSE;
import static edu.hw8.Task1.Message.STUPID_REQUEST;
import static edu.hw8.Task1.Message.STUPID_RESPONSE;
import static edu.hw8.Task1.QuoteClient.LOCAL_HOST;
import static edu.hw8.Task1.QuoteServer.PORT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CorrectAnswerTest {

    @Test
    void test_server_response() {
        QuoteServer server = new QuoteServer();
        server.startServer();
        new QuoteClient();
        try (Socket socket = new Socket(LOCAL_HOST, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println(PERSONALITIES_REQUEST.get());
            assertThat(PERSONALITIES_RESPONSE.get()).isEqualTo(in.readLine());

            out.println(INSULTS_REQUEST.get());
            assertThat(INSULTS_RESPONSE.get()).isEqualTo(in.readLine());

            out.println(STUPID_REQUEST.get());
            assertThat(STUPID_RESPONSE.get()).isEqualTo(in.readLine());

            out.println(INTELLIGENCE_REQUEST.get());
            assertThat(INTELLIGENCE_RESPONSE.get()).isEqualTo(in.readLine());
        } catch (IOException ignored){
        }
    }
}
