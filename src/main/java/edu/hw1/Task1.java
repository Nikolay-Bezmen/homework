package edu.hw1;

import java.io.IOException;

public class Task1 {
    public long minutesToSeconds(String timeOfVideo) throws IOException {
        String[] times = timeOfVideo.split(":");
        if (times.length != 2 || times[1].length() != 2) {
            throw new IOException("некоректный ввод");
        }

        for (char ch : times[0].toCharArray()) {
            if (ch < '0' || ch > '9') {
                throw new IOException("неизвестный символ");
            }
        }
        for (char ch : times[1].toCharArray()) {
            if (ch < '0' || ch > '9') {
                throw new IOException("неизвестный символ");
            }
        }
        int minutes = Integer.parseInt(times[0]);
        int seconds = Integer.parseInt(times[1]);
        if (seconds >= 60) {
            return -1;
        }

        if ((Integer.MAX_VALUE / 60) < minutes ||
            (Integer.MAX_VALUE / 60) <= minutes && seconds >= (Integer.MAX_VALUE % 60)) {
            throw new IOException("некоректные цифры во вводе");
        }

        return (minutes * 60L) + seconds;
    }
}
