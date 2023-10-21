package edu.hw3;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings({"HideUtilityClassConstructor", "MagicNumber"})
public class Task4 {
    public static final String INCORRECT_NUMBER = "incorrect number";

    public static String convertToRoman(int num) {
        int number = num;
        if (number >= 4000 || number < 0) {
            throw new IllegalArgumentException(INCORRECT_NUMBER);
        }

        if (number == 0) {
            return "";
        }

        Map<Integer, String> convert = new LinkedHashMap<>();
        convert.put(1000, "M");
        convert.put(900, "CM");
        convert.put(500, "D");
        convert.put(400, "CD");
        convert.put(100, "C");
        convert.put(90, "XC");
        convert.put(50, "L");
        convert.put(40, "XL");
        convert.put(10, "X");
        convert.put(9, "IX");
        convert.put(5, "V");
        convert.put(4, "IV");
        convert.put(1, "I");

        StringBuilder sb = new StringBuilder();

        for (var box : convert.entrySet()) {
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
