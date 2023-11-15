package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task7 {
    public static boolean task1(String line) {
        String regex = "^[01]{2}0[01]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        return matcher.matches();
    }

    public static boolean task2(String line) {
        String regex = "^(0([01]*0)?|1([01]*1)?)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        return matcher.matches();
    }

    public static boolean task3(String line) {
        String regex = "^[01]{1,3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        return matcher.matches();
    }
}
