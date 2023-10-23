package edu.hw3;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task1 {
    public static String atbash(String line) {
        if (line == null) {
            return null;
        }
        StringBuilder ans = new StringBuilder();
        for (char ch : line.toCharArray()) {
            char symbol = ch;
            if (Character.isAlphabetic(ch)) {
                symbol = getMirrorLetter(ch);
            }

            ans.append(symbol);
        }

        return ans.toString();
    }

    protected static char getMirrorLetter(char letter) {
        char mirrorLetter;
        if (letter <= 'Z') {
            int bigA = 'Z' - letter;
            mirrorLetter = (char) (bigA + 'A');
        } else {
            int a = 'z' - letter;
            mirrorLetter = (char) (a + 'a');
        }

        return mirrorLetter;
    }
}
