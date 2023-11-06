package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings({"HideUtilityClassConstructor", "ReturnCount"})
public class Task3 {
    private final static String TODAY = "today";
    private final static String YESTERDAY = "yesterday";
    private final static String TOMORROW = "tomorrow";
    private final static DateTimeFormatter[] FORMATTERS = {
        DateTimeFormatter.ofPattern("yyyy-MM-dd"),
        DateTimeFormatter.ofPattern("yyyy-M-d"),
        DateTimeFormatter.ofPattern("M/d/yyyy"),
        DateTimeFormatter.ofPattern("M/d/yy")
    };

    public static Optional<LocalDate> parseDate(String string) {
        for (DateTimeFormatter formatter : FORMATTERS) {
            try {
                LocalDate date = LocalDate.parse(string, formatter);
                return Optional.of(date);
            } catch (Exception ignored) {
            }
        }

        LocalDate today = LocalDate.now();

        switch (string) {
            case YESTERDAY -> {
                return Optional.of(today.minusDays(1));
            }
            case TODAY -> {
                return Optional.of(today);
            }
            case TOMORROW -> {
                return Optional.of(today.plusDays(1));
            }
            default -> {
            }
        }

        Pattern pattern = Pattern.compile("^(\\d+) days? ago$");
        Matcher matcher = pattern.matcher(string);

        if (matcher.matches()) {
            return Optional.of(today.minusDays(Integer.parseInt(matcher.group(1))));
        }

        return Optional.empty();
    }
}
