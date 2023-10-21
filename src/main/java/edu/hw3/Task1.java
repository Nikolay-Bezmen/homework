package edu.hw3;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task1 {
    public static String atbash(String line) {
        if (line == null) {
            return null;
        }
        StringBuilder ans = new StringBuilder();
        for (char ch : line.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                char symbol;
                if (ch <= 'Z') {
                    int bigA = 'Z' - ch;
                    symbol = (char) (bigA + 'A');
                } else {
                    int a = 'z' - ch;
                    symbol = (char) (a + 'a');
                }

                ans.append(symbol);
            } else {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}
