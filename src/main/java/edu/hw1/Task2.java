package edu.hw1;

@SuppressWarnings("MagicNumber")
public class Task2 {
    public int countDigits(long num) {
        long x = Math.abs(num);
        if (x == 0) {
            return 1;
        }
        int countDigit = 0;
        long flag = 1;
        while (x >= flag) {
            flag *= 10;
            ++countDigit;
        }
        return countDigit;
    }
}
