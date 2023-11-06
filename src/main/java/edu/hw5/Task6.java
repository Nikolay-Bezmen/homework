package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task6 {
    public static boolean isSubsequence(String s, String t) {
        Pattern pattern = Pattern.compile(s);
        Matcher matcher = pattern.matcher(t);

        return matcher.find();
    }
}
