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

        if (i + 1 < n && args[i].equals("--path")) {
            String p = args[i + 1].trim();
            if (p.startsWith("http")) {
                uri = p;
            } else {
                if (p.endsWith("*")) {
                    pathToLogFile = p.substring(0, p.length() - 1);
                } else {
                    pathToLogFile = p;
                }
            }
            ++i;
            ++i;
        }

        if (i + 1 < n && args[i].equals("--from")) {
            String[] date = args[i + 1].trim().split("-");
            from = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
            ++i;
            ++i;
        }

        if (i + 1 < n && args[i].equals("--to")) {
            String[] date = args[i + 1].trim().split("-");
            to = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
            ++i;
            ++i;
        }

        if (i + 1 < n && args[i].equals("--format")) {
            patternFile = args[i + 1].trim();
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
}
