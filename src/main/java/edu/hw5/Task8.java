package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task8 {
    public static boolean task1(String line) {
        String regex = "^([01]{2})*[01]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        return matcher.matches();
    }

    public static boolean task2(String line) {
        String regex = "^0([01]{2})*|1([01]{2})*[01]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        return matcher.matches();
    }

    public static boolean task3(String line) {
        String regex = "^([01]{3})*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        return matcher.matches();
    }

    public static boolean task4(String line) {
        String regex = "^(?!11$)(?!111$)[01]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        return matcher.matches();
    }

    public static boolean task5(String line) {
        String regex = "^(1[01])*(1)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        return matcher.matches();
    }

    public static boolean task6(String line) {
        String regex = "^(1?0{2,}|01?0+|0{2,}1?0*)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        return matcher.matches();
    }

    public static boolean task7(String line) {
        String regex = "^(?!.*11.*$)[01]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        return matcher.matches();
    }
}
