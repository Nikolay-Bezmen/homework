package edu.hw1;

public class Task2 {
    public int countDigits(long num) {
        final int ten = 10;

        long x = Math.abs(num);
        if (x == 0) {
            return 1;
        }
        int countDigit = 0;
        long flag = 1;
        while (x >= flag) {
            flag *= ten;
            ++countDigit;
        }
        return countDigit;
    }
}
