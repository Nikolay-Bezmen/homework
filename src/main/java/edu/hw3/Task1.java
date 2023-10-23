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
                ans.append(getMirrorLetter(ch));
            } else {
                ans.append(ch);
            }
        }

        return ans.toString();
    }

    protected static char getMirrorLetter(char letter) {
        if (letter <= 'Z') {
            int bigA = 'Z' - letter;
            return (char) (bigA + 'A');
        } else {
            int a = 'z' - letter;
            return (char) (a + 'a');
        }
    }
}
