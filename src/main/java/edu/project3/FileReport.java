package edu.project3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


@SuppressWarnings("HideUtilityClassConstructor")
public class FileReport {
    public static void writeReportInFile(String patternFile, List<String> statistics) {
        if (patternFile.equals("markdown")) {
            reportToMarkdown(statistics);
        } else if (patternFile.equals("adoc")) {
            reportToAdoc(statistics);
        }
    }

    private static void reportToMarkdown(List<String> statistics) {
        try (FileWriter fw = new FileWriter("src/main/java/edu/project3/Storage/stata.md")) {
            for (String statistic : statistics) {
                fw.write(statistic);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void reportToAdoc(List<String> statistics) {
        try (FileWriter fw = new FileWriter("src/main/java/edu/project3/Storage/stata.adoc")) {
            for (String statistic : statistics) {
                fw.write(statistic);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
