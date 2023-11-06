package edu.hw5;

import java.util.regex.Pattern;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task5 {
    public static boolean checkOnValidMachineNumber(String number) {
        String regex = "^[A-Z]\\d{3}[A-Z]{2}\\d{3}";
        return Pattern.matches(regex, number);
    }
}
