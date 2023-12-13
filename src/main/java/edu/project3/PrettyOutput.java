package edu.project3;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Map.Entry;
import org.apache.logging.log4j.core.util.KeyValuePair;

@SuppressWarnings({"MagicNumber", "MultipleStringLiterals", "InnerTypeLast"})
public class PrettyOutput {
    private final boolean isMarkdownFile;

    PrettyOutput(String pattern) {
        isMarkdownFile = pattern.equals("markdown");
    }

    public String printCodeAnswersStatistic(List<KeyValuePair> list) {
        HttpAnswersMap answers = new HttpAnswersMap();
        StringBuilder sb = new StringBuilder();
        String formatter = isMarkdownFile ? "|%-5s|%-23s|%12s |\n" : "|%-5s|%-23s|%12s \n";
        String separatorLine = getSeparatorLine(new int[] {3, 21, 11});

        sb.append(getTitle("Самые популярные ошибки"));
        sb.append(String.format(
            formatter,
            StringUtils.center("Код", 5),
            StringUtils.center("Имя", 23),
            StringUtils.center("Количество", 12)
        ));
        sb.append(separatorLine);

        for (var e : list) {
            sb.append(String.format(formatter, StringUtils.center(e.getKey(), 5),
                StringUtils.center(answers.getMessageFromCode(Integer.parseInt(e.getKey())), 23),
                e.getValue()
            ));
        }

        if (!isMarkdownFile) {
            sb.append("|===\n");
        }

        return sb.toString();
    }

    public String printMorePopularRequests(List<KeyValuePair> list) {
        StringBuilder sb = new StringBuilder();
        String formatter = isMarkdownFile ? "|%-40s|%11s |\n" : "|%-40s|%11s \n";
        String separatorLine = getSeparatorLine(new int[] {38, 10});

        sb.append(getTitle("Самые популярные запросы"));
        sb.append(String.format(formatter, StringUtils.center("Ресурс", 40), "Количество"));
        sb.append(separatorLine);
        for (var e : list) {
            sb.append(String.format(formatter, StringUtils.center(e.getKey(), 40),
                e.getValue()
            ));
        }

        if (!isMarkdownFile) {
            sb.append("|===\n");
        }

        return sb.toString();
    }

    public String printTotalInfo(LogAnalysis logAnalysis, int countRequests, double averageSizeRequest) {
        StringBuilder sb = new StringBuilder();
        String formatter =
            isMarkdownFile ? "|%30s|%20s |\n" : "|%30s|%20s \n";
        String separatorLine = getSeparatorLine(new int[] {28, 19});
        LocalDate from = logAnalysis.getDateFrom();
        LocalDate to = logAnalysis.getDateTo();
        sb.append(getTitle("Общая информация"));
        sb.append(String.format(formatter, StringUtils.center("Метрика", 30), "Значение"));
        sb.append(separatorLine);

        if (logAnalysis.getUriPath() == null) {
            String path = logAnalysis.getPathToLogFile();
            if (path.endsWith(".txt")) {
                String fileName = path.substring(path.lastIndexOf('/') + 1);
                sb.append(String.format(formatter, StringUtils.center("Файл(-ы)", 30),
                    String.format("'%s'", fileName)
                ));
            } else {
                sb.append(getAllTxtFilesFromDirectory(path, formatter));
            }
        } else {
            sb.append(String.format(formatter, StringUtils.center("Файл(-ы)", 30), "-"));
        }

        sb.append(String.format(formatter, StringUtils.center("Начальная дата", 30),
            from == null ? "-" : from
        ));

        sb.append(String.format(formatter, StringUtils.center("Конечная дата", 30),
            to == null ? "-" : to
        ));

        sb.append(String.format(formatter, StringUtils.center("Количество запросов", 30),
            countRequests
        ));
        sb.append(String.format(formatter, StringUtils.center("Средний размер ответа", 30),
            String.format("%db", (int) averageSizeRequest)
        ));
        if (!isMarkdownFile) {
            sb.append("|===\n");
        }

        return sb.toString();
    }

    public String printDayWithMoreRequests(Entry<LocalDate, Long> entryDay) {
        if (entryDay == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String formatter = isMarkdownFile ? "|%20s|%15s |\n" : "|%20s|%15s \n";
        String separatorLine = getSeparatorLine(new int[] {18, 14});

        sb.append(getTitle("Самый насыщенный день"));
        sb.append(String.format(formatter, StringUtils.center("День", 20), "Число запросов"));
        sb.append(separatorLine);
        sb.append(String.format(formatter, StringUtils.center(entryDay.getKey().toString(), 20),
            entryDay.getValue()
        ));

        if (!isMarkdownFile) {
            sb.append("|===\n");
        }

        return sb.toString();
    }

    private String getAllTxtFilesFromDirectory(String path, String formatter) {
        StringBuilder sb = new StringBuilder();
        File[] files = new File(path).listFiles();
        if (files != null) {
            sb.append(getAllFilesFromDirectoryInSuitableFormat(files, formatter));
        } else {
            sb.append(String.format(formatter, StringUtils.center("Файл(-ы)", 30), "-"));
        }

        return sb.toString();
    }

    private StringBuilder getAllFilesFromDirectoryInSuitableFormat(File[] files, String formatter) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < files.length; ++i) {
            String name = files[i].getName();
            if (name.endsWith(".txt")) {
                sb.append(String.format(
                    formatter,
                    StringUtils.center(String.format("Файл - %d", i + 1), 30),
                    String.format("'%s'", name)
                ));
            }
        }

        return sb;
    }

    public String printResourcesWithMostPopularCodeError404(List<KeyValuePair> list) {
        StringBuilder sb = new StringBuilder();

        String formatter = isMarkdownFile ? "|%40s|%11s |\n" : "|%40s|%11s \n";
        String separatorLine = getSeparatorLine(new int[] {38, 10});

        sb.append(getTitle("Самые частые ресурсы с 404 ошибками"));
        sb.append(String.format(formatter, StringUtils.center("Ресурс", 40), "Количество"));
        sb.append(separatorLine);
        for (var entry : list) {
            sb.append(String.format(formatter, StringUtils.center(entry.getKey(), 40), entry.getValue()));
        }
        if (!isMarkdownFile) {
            sb.append("|===\n");
        }

        return sb.toString();
    }

    public String printDayOfWeekWithCountRequestsInThisDay(List<KeyValuePair> list) {
        StringBuilder sb = new StringBuilder();

        String formatter = isMarkdownFile ? "|%25s|%11s |\n" : "|%25s|%11s \n";
        String separatorLine = getSeparatorLine(new int[] {23, 10});

        sb.append(getTitle("Популярность запросов по дням недели"));
        sb.append(String.format(formatter, StringUtils.center("День недели", 25), "Количество"));
        sb.append(separatorLine);
        for (var entry : list) {
            sb.append(String.format(formatter, StringUtils.center(entry.getKey(), 25), entry.getValue()));
        }

        if (!isMarkdownFile) {
            sb.append("|===\n");
        }

        return sb.toString();
    }

    private static class StringUtils {
        public static String center(String s, int size) {
            return center(s, size, ' ');
        }

        public static String center(String s, int size, char pad) {
            if (s == null || size <= s.length()) {
                return s;
            }
            StringBuilder sb = new StringBuilder(size);
            sb.append(String.valueOf(pad).repeat((size - s.length()) / 2));
            sb.append(s);
            while (sb.length() < size) {
                sb.append(pad);
            }
            return sb.toString();
        }
    }

    private String getTitle(String title) {
        if (isMarkdownFile) {
            return String.format("#### %s\n", title);
        } else {
            return String.format("==== %s\n|===\n", title);
        }
    }

    private String getSeparatorLine(int[] columns) {
        if (isMarkdownFile) {
            StringBuilder sb = new StringBuilder();
            sb.append("|");
            for (int column : columns) {
                sb.append(":");
                sb.append("-".repeat(Math.max(0, column)));
                sb.append(":").append("|");
            }
            sb.append("\n");
            return sb.toString();
        } else {
            return "";
        }
    }
}
