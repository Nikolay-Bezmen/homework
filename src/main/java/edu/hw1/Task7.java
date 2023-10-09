package edu.hw1;

public class Task7 {
    public static final String INCORRECT_SHIFT_FORMAT = "неверный формат сдвига";
    public static final String NUMBER_SHOULD_BE_POSSIBLE = "число должно быть положительным";

    public int rotateRight(int num, int shift) {
        if (shift < 0) {
            throw new IllegalArgumentException(INCORRECT_SHIFT_FORMAT);
        }
        if (num <= 0) {
            throw new IllegalArgumentException(NUMBER_SHOULD_BE_POSSIBLE);
        }
        String binaryNum = Integer.toBinaryString(num);
        int cycle = binaryNum.length();
        int i = shift % cycle;
        if (i == 0) {
            return num;
        }
        String newBinaryNum = binaryNum.substring(cycle - i, cycle).concat(binaryNum.substring(0, cycle - i));
        return Integer.parseInt(newBinaryNum, 2);
    }

    public int rotateLeft(int num, int shift) {
        if (shift < 0) {
            throw new IllegalArgumentException(INCORRECT_SHIFT_FORMAT);
        }
        if (num <= 0) {
            throw new IllegalArgumentException(NUMBER_SHOULD_BE_POSSIBLE);
        }
        String binaryNum = Integer.toBinaryString(num);
        int cycle = binaryNum.length();
        int i = shift % cycle;
        if (i == 0) {
            return num;
        }
        String newBinaryNum = binaryNum.substring(i, cycle).concat(binaryNum.substring(0, i));
        return Integer.parseInt(newBinaryNum, 2);
    }
}
