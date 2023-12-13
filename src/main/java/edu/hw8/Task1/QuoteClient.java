package edu.hw8.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

@SuppressWarnings({"HideUtilityClassConstructor", "UncommentedMain"})
public class QuoteClient {
    private static final int PORT = 9090;
    static final String LOCAL_HOST = "localhost";

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket(LOCAL_HOST, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
            }
        }
    }
}
