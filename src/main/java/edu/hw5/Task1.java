package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings({"HideUtilityClassConstructor", "MagicNumber"})
public class Task1 {
    public final static String INCORRECT_FORMAT = "incorrect format";
    public final static String INCORRECT_DATE = "so date is not exist";
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
    private static String sessionRegex =
        "^(\\d{4}-\\d{2}-\\d{2}, \\d{2}:\\d{2}) - (\\d{4}-\\d{2}-\\d{2}, \\d{2}:\\d{2})$";
    private static final Pattern PATTERN = Pattern.compile(sessionRegex);

    public static String averageTimeOfOneSession(String[] sessions) {
        List<Long> timeOfSessions = new ArrayList<>();
        for (String session : sessions) {
            Matcher matcher = PATTERN.matcher(session);

            if (matcher.matches()) {
                try {
                    LocalDateTime timeOfStart = LocalDateTime.parse(matcher.group(1).trim(), formatter);
                    LocalDateTime timeOfEnd = LocalDateTime.parse(matcher.group(2), formatter);
                    Duration timeOfSession = Duration.between(timeOfStart, timeOfEnd);
                    timeOfSessions.add(timeOfSession.toMinutes());
                } catch (Exception e) {
                    throw new IllegalArgumentException(INCORRECT_DATE);
                }
            } else {
                throw new IllegalArgumentException(INCORRECT_FORMAT);
            }
        }
        long totallyCountMinutes = timeOfSessions.stream()
            .mapToInt(Long::intValue)
            .sum();
        long averageTimeOfOneSession = totallyCountMinutes / (timeOfSessions.size());

        return averageTimeOfOneSession / 60
            + "ч "
            + averageTimeOfOneSession % 60
            + "м";
    }
}
