package edu.hw1;

public class Task1 {
    public static long minutesToSeconds(String timeOfVideo) {
        String[] times = timeOfVideo.split(":");
        int minutes = Integer.parseInt(times[0]);
        int seconds = Integer.parseInt(times[1]);
        if (seconds >= 60) {
            return -1;
        }

        return (minutes * 60L) + seconds;
    }
}
