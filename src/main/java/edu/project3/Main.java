package edu.project3;

import java.io.IOException;
import java.time.LocalDate;

@SuppressWarnings("HideUtilityClassConstructor")
public class Main {
    public static void main(String[] args) throws IOException {
        int i = 0;
        int n = args.length;
        LocalDate from = null;
        LocalDate to = null;
        String patternFile = null;
        String uri = null;
        String pathToLogFile = null;
        if (i + 1 < n && args[i].equals("-jar")) {
            ++i;
            ++i;
        }

        while (i < args.length - 1) {
            switch (args[i]) {
                case "--path" -> {
                    String arg = args[i + 1].trim();
                    if (arg.startsWith("http")) {
                        uri = arg;
                    } else {
                        pathToLogFile = arg.endsWith("*") ? arg.substring(0, arg.length() - 1) : arg;
                    }
                    ++i;
                }
                case "--from" -> {
                    from = processDate(args[i + 1].trim().split("-"));
                    ++i;
                }
                case "--to" -> {
                    to = processDate(args[i + 1].trim().split("-"));
                    ++i;
                }
                case "--format" -> {
                    patternFile = args[i + 1].trim();
                    ++i;
                }
                default -> { }
            }
            ++i;
        }
        LogAnalysis logAnalysis = new LogAnalysis(from,
            to, patternFile, uri,
            pathToLogFile
        );
        logAnalysis.inicializeListLogRecords();
        LogReport logReport =
            new LogReport(logAnalysis);
        logReport.getReport();
    }

    private static LocalDate processDate(String[] dateLine) {
        return LocalDate.of(Integer.parseInt(dateLine[0]),
            Integer.parseInt(dateLine[1]), Integer.parseInt(dateLine[2])
        );
    }
}
