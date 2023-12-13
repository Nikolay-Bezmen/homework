package edu.hw8.Task1;

import org.junit.jupiter.api.*;
import java.io.*;
import java.net.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static edu.hw8.Task1.QuoteClient.LOCAL_HOST;
import static edu.hw8.Task1.QuoteServer.MAX_CONNECTIONS;
import static edu.hw8.Task1.QuoteServer.PORT;
import static edu.hw8.Task1.QuoteServer.SEMAPHORE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class QuoteServerClientTest {
    @Test
    void test_if_count_client_more_than_count_connections() throws InterruptedException {
        QuoteServer server = new QuoteServer();
        server.startServer();
        ExecutorService service = Executors.newFixedThreadPool(QuoteServer.MAX_CONNECTIONS);
        CountDownLatch latch = new CountDownLatch(QuoteServer.MAX_CONNECTIONS);

        assertThat(SEMAPHORE.tryAcquire(MAX_CONNECTIONS - 1)).isTrue();
        assertThat(SEMAPHORE.tryAcquire(MAX_CONNECTIONS + 1)).isFalse();
        for (int i = 0; i < 5; i++) {
            service.submit(() -> {
                try {
                    Socket socket = new Socket(LOCAL_HOST, PORT);
                    latch.countDown();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        latch.await(1, TimeUnit.MINUTES);

        assertThat(SEMAPHORE.tryAcquire()).isFalse();
    }

}

