package edu.hw8.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import static edu.hw8.Task1.Message.INSULTS_REQUEST;
import static edu.hw8.Task1.Message.INSULTS_RESPONSE;
import static edu.hw8.Task1.Message.INTELLIGENCE_REQUEST;
import static edu.hw8.Task1.Message.INTELLIGENCE_RESPONSE;
import static edu.hw8.Task1.Message.PERSONALITIES_REQUEST;
import static edu.hw8.Task1.Message.PERSONALITIES_RESPONSE;
import static edu.hw8.Task1.Message.STUPID_REQUEST;
import static edu.hw8.Task1.Message.STUPID_RESPONSE;
import static edu.hw8.Task1.Message.UNKNOWN_RESPONSE;

@SuppressWarnings({"UncommentedMain", "ImportOrder"})
public class QuoteServer {
    static final int MAX_CONNECTIONS = 5;
    static final int PORT = 9090;
    static final Semaphore SEMAPHORE = new Semaphore(MAX_CONNECTIONS);
    private static final ExecutorService EXECUTOR = Executors.newWorkStealingPool();
    private static final ConcurrentHashMap<String, String> QUOTES = new ConcurrentHashMap<>();

    static {
        QUOTES.put(PERSONALITIES_REQUEST.get(), PERSONALITIES_RESPONSE.get());
        QUOTES.put(INSULTS_REQUEST.get(), INSULTS_RESPONSE.get());
        QUOTES.put(STUPID_REQUEST.get(), STUPID_RESPONSE.get());
        QUOTES.put(INTELLIGENCE_REQUEST.get(), INTELLIGENCE_RESPONSE.get());
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            try {
                SEMAPHORE.acquire();
                Socket clientSocket = serverSocket.accept();
                EXECUTOR.submit(new ClientHandler(clientSocket));
            } catch (InterruptedException | IOException ignored) {
            }
        }
    }

    public void startServer() {
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(PORT);
                while (true) {
                    try {
                        SEMAPHORE.acquire();
                        Socket clientSocket = serverSocket.accept();
                        EXECUTOR.submit(new ClientHandler(clientSocket));
                    } catch (InterruptedException | IOException ignored) {
                    }
                }
            } catch (IOException ignored) {
            }
        }).start();
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public static void stopServer() throws InterruptedException {
            EXECUTOR.close();
        }

        @Override
        public void run() {
            try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    out.println(QUOTES.getOrDefault(inputLine, UNKNOWN_RESPONSE.get()));
                }
            } catch (IOException ignored) {
            } finally {
                SEMAPHORE.release();
                try {
                    clientSocket.close();
                } catch (IOException ignored) {
                }
            }
        }
    }
}
