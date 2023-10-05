package edu.hw1;

import java.io.IOException;

public class Task1 {
    public final String uncorrectDigitInInput = "некоректные цифры во вводе";
    public final String uncorrectInput = "некоректный ввод";

    public final String notDigitSymbol = "неизвестный символ";

    public long minutesToSeconds(String timeOfVideo) throws IOException {
        final int sixty = 60;
        final int two = 2;
        final long sixtyL = 60L;
        String[] times = timeOfVideo.split(":");
        if (times.length != two || times[1].length() != two) {
            throw new IOException(uncorrectInput);
        }

        for (char ch : times[0].toCharArray()) {
            if (ch < '0' || ch > '9') {
                throw new IOException(notDigitSymbol);
            }
        }
        for (char ch : times[1].toCharArray()) {
            if (ch < '0' || ch > '9') {
                throw new IOException(notDigitSymbol);
            }
        }
        int minutes = Integer.parseInt(times[0]);
        int seconds = Integer.parseInt(times[1]);
        if (seconds >= sixty) {
            return -1;
        }
        boolean a = (Integer.MAX_VALUE / sixty) < minutes;
        boolean b = (Integer.MAX_VALUE / sixty) <= minutes && seconds >= (Integer.MAX_VALUE % sixty);
        if (a || b) {
            throw new IOException(uncorrectDigitInInput);
        }

        return (minutes * sixtyL) + seconds;
    }
}
