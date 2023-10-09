package edu.hw1;

import java.io.IOException;

public class Task1 {
    public static final String INCORRECT_DIGIT_IN_INPUT = "некоректные цифры во вводе";
    public static final String INCORRECT_INPUT = "некоректный ввод";

    public static final String SYMBOL_IS_NOT_DIGIT = "неизвестный символ";

    public int minutesToSeconds(String timeOfVideo) throws IOException {
        String[] times = timeOfVideo.split(":");
        if (times.length != 2 || times[1].length() != 2) {
            throw new IOException(INCORRECT_INPUT);
        }

        for (char ch : times[0].toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IOException(SYMBOL_IS_NOT_DIGIT);
            }
        }
        for (char ch : times[1].toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IOException(SYMBOL_IS_NOT_DIGIT);
            }
        }
        int minutes = Integer.parseInt(times[0]);
        int seconds = Integer.parseInt(times[1]);
        if (seconds >= 60) {
            return -1;
        }
        boolean isMinutesValueOverflow = (Integer.MAX_VALUE / 60) < minutes;
        boolean isSecondsValueOverFlow = (Integer.MAX_VALUE / 60) <= minutes && seconds >= (Integer.MAX_VALUE % 60);
        if (isMinutesValueOverflow || isSecondsValueOverFlow) {
            throw new IOException(INCORRECT_DIGIT_IN_INPUT);
        }

        return (minutes * 60) + seconds;
    }
}
