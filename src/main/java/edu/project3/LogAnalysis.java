package edu.project3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("MultipleStringLiterals")
public class LogAnalysis {
    private static final String NOT_FOUND = "404: Not Found";
    private List<LogRecord> totalLogRecords = new LinkedList<>();
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String patternFileOutPut;
    private URI uriPath;
    private String pathToLogFile;

    public LogAnalysis(LocalDate from, LocalDate to, String patternFile, String uri, String pathToLogFile)
        throws IOException {
        dateFrom = from;
        dateTo = to;
        patternFileOutPut = patternFile;
        if (uri != null) {
            uriPath = URI.create(uri);
            this.pathToLogFile = null;
        } else {
            uriPath = null;
            this.pathToLogFile = pathToLogFile;
        }
    }

    public List<LogRecord> getTotalLogRecords() {
        return totalLogRecords;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public String getPatternFileOutPut() {
        return patternFileOutPut;
    }

    public URI getUriPath() {
        return uriPath;
    }

    public String getPathToLogFile() {
        return pathToLogFile;
    }

    public final void inicializeListLogRecords() throws IOException {
        if (uriPath != null) {
            inicializeWithUseUrl();
        } else {
            if (pathToLogFile.endsWith(".txt")) {
                inicializeFromOneLogFile();
            } else {
                inicializeFromDirectoryManyLogFiles();
            }
        }
    }

    private void inicializeWithUseUrl() throws IOException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(uriPath).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String bodyResponse = response.body();
            if (bodyResponse.equals(NOT_FOUND)) {
                throw new IOException();
            }

            List<String> lines = Arrays.stream(bodyResponse.split("\n")).toList();
            totalLogRecords
                .addAll(Objects
                    .requireNonNull(LogParse
                        .parseListLogRecords(lines)));
        } catch (IOException | InterruptedException e) {
            throw new IOException(NOT_FOUND);
        }
    }

    private void inicializeFromOneLogFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(pathToLogFile))) {
            String line;
            List<String> lines = new LinkedList<>();
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

            totalLogRecords.addAll(Objects
                .requireNonNull(LogParse
                    .parseListLogRecords(lines)));
        } catch (IOException e) {
            throw new IOException(NOT_FOUND);
        }
    }

    private void inicializeFromDirectoryManyLogFiles() throws IOException {
        File directory = new File(pathToLogFile);
        File[] files = directory.listFiles();
        if (files == null) {
            throw new IOException(NOT_FOUND);
        }

        for (File file : files) {
            if (file.getName().endsWith(".txt")) {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                    List<String> lines = new LinkedList<>();
                    while ((line = br.readLine()) != null) {
                        lines.add(line);
                    }

                    totalLogRecords.addAll(Objects
                        .requireNonNull(LogParse
                            .parseListLogRecords(lines)));
                } catch (IOException e) {
                    throw new IOException(NOT_FOUND);
                }
            }
        }
    }
}
