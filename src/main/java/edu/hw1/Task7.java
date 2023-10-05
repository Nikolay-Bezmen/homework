package edu.hw1;

public class Task7 {
    public static int rotateRight(int num, int shift) {
        String binaryNum = Integer.toBinaryString(num);
        int cycle = binaryNum.length();
        int i = shift % cycle;
        String newBinaryNum = binaryNum.substring(cycle - i, cycle).concat(binaryNum.substring(0, cycle - i));
        return Integer.parseInt(newBinaryNum, 2);
    }

    public static int rotateLeft(int num, int shift) {
        String binaryNum = Integer.toBinaryString(num);
        int cycle = binaryNum.length();
        int i = shift % cycle;
        String newBinaryNum = binaryNum.substring(i, cycle).concat(binaryNum.substring(0, i));
        return Integer.parseInt(newBinaryNum, 2);
    }
}
