package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@SuppressWarnings("HideUtilityClassConstructor")
public class Task4 {
    public static boolean specialPassword(String password) {
        Matcher matcher = Pattern.compile("[~!@#$%^&*|]").matcher(password);
        return matcher.find();
    }
}
