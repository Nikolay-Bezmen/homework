package edu.hw1;

public class Task5 {
    public static boolean isPalindromeDescendant(int number) {
        String numberString = String.valueOf(number);

        while (numberString.length() > 1) {
            if (isPalindrome(numberString)) {
                return true;
            }
            int n = numberString.length();
            n -= (n % 2);
            StringBuilder newNumber = new StringBuilder();
            for (int i = 0; i < n; i += 2) {
                int a = (numberString.charAt(i) - '0') + (numberString.charAt(i + 1) - '0');
                String strA = String.valueOf(a);
                newNumber.append(strA);
            }
            if (n != numberString.length()) {
                newNumber.append(numberString.charAt(n));
            }
            numberString = newNumber.toString();
        }

        return false;
    }

    public static boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; ++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
