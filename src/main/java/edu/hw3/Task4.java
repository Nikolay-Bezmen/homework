package edu.hw3;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings({"HideUtilityClassConstructor", "MagicNumber"})
public class Task4 {
    private static final Map<Integer, String> CONVERT = new LinkedHashMap<>();
    public static final String INCORRECT_NUMBER = "incorrect number";

    public static String convertToRoman(int num) {
        int number = num;
        if (number >= 4000 || number < 0) {
            throw new IllegalArgumentException(INCORRECT_NUMBER);
        }

        if (number == 0) {
            return "";
        }
        CONVERT.put(1000, "M");
        CONVERT.put(900, "CM");
        CONVERT.put(500, "D");
        CONVERT.put(400, "CD");
        CONVERT.put(100, "C");
        CONVERT.put(90, "XC");
        CONVERT.put(50, "L");
        CONVERT.put(40, "XL");
        CONVERT.put(10, "X");
        CONVERT.put(9, "IX");
        CONVERT.put(5, "V");
        CONVERT.put(4, "IV");
        CONVERT.put(1, "I");

        StringBuilder sb = new StringBuilder();

        for (var box : CONVERT.entrySet()) {
            while (box.getKey() <= number) {
                sb.append(box.getValue());
                number -= box.getKey();
            }
            if (number <= 0) {
                break;
            }
        }

        return sb.toString();
    }
}
