package edu.hw1;

public class Task2 {
    public static int countDigits(long number) {
        number = Math.abs(number);
        if (number == 0) {
            return 1;
        }
        int count_digit = 0;
        long flag = 1;
        while (number >= flag) {
            flag *= 10;
            ++count_digit;
        }

        return count_digit;
    }
}
