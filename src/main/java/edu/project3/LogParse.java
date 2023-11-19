package edu.project3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings({"HideUtilityClassConstructor", "ConstantName", "MagicNumber", "IllegalIdentifierName"})
public class LogParse {
    public static final String INCORRECT_RECORD = "record not suitable for pattern";
    private static final Pattern patternLineLog = Pattern.compile("^(\\S+) (\\S+) (\\S+) "
        + "\\[([\\w:/]+\\s[+\\-]\\d{4})] \"([^\"]+)\" (\\d{3}) (\\d+) "
        + "\"([^\"]+)\" \"([^\"]+)\"$");
    private static final DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);

    private static LogRecord parseLogRecordFromLine(String line) {
        Matcher matcherLog = patternLineLog.matcher(line);
        try {
            if (matcherLog.matches()) {
                return new LogRecord(
                    matcherLog.group(1),
                    matcherLog.group(2),
                    LocalDateTime.parse(matcherLog.group(4), formatter),
                    matcherLog.group(5),
                    Integer.parseInt(matcherLog.group(6)),
                    Double.parseDouble(matcherLog.group(7)),
                    matcherLog.group(8),
                    matcherLog.group(9)
                );
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INCORRECT_RECORD);
        }

        return null;
    }

    public static List<LogRecord> parseListLogRecords(List<String> listLineLogs) {
        List<LogRecord> listLogRecords = new LinkedList<>();
        for (String record : listLineLogs) {
            LogRecord logRecord = parseLogRecordFromLine(record);

            if (logRecord == null) {
                throw new IllegalArgumentException(INCORRECT_RECORD);
            }

            listLogRecords.add(logRecord);
        }

        return listLogRecords;
    }
}
