package edu.hw1;

public class Task4 {
    public String fixString(String brokenString) {
        int n = brokenString.length() - brokenString.length() % 2;
        StringBuilder correctString = new StringBuilder();
        for (int i = 0; i < n; i += 2) {
            correctString.append(brokenString.charAt(i + 1));
            correctString.append(brokenString.charAt(i));
        }

        if (n != brokenString.length()) {
            correctString.append(brokenString.charAt(n));
        }

        return correctString.toString();
    }
}
