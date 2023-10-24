package edu.hw3;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task2 {
    public static final String INPUT_LINE_IS_NOT_VALID = "input line is not valid";

    public static String[] clusterize(String line) {
        int countClasters = amountValidClasters(line);
        if (countClasters == -1) {
            throw new IllegalArgumentException(INPUT_LINE_IS_NOT_VALID);
        }
        String[] clasters = new String[countClasters];
        int counter = 0;
        int i = 0;
        StringBuilder claster = new StringBuilder();

        for (char ch : line.toCharArray()) {
            if (ch == ')') {
                --counter;
            } else {
                ++counter;
            }
            claster.append(ch);
            if (counter == 0) {
                clasters[i++] = claster.toString();
                claster.delete(0, claster.length());
            }
        }

        return clasters;
    }

    public static int amountValidClasters(String str) {
        int counter = 0;
        int countClasters = 0;
        for (char ch : str.toCharArray()) {
            if (ch == ')') {
                --counter;
            } else {
                ++counter;
            }
            if (counter == 0) {
                ++countClasters;
            }
            if (counter < 0) {
                return -1;
            }
        }
        if (counter == 0) {
            return countClasters;
        }

        return -1;
    }
}
