package edu.hw1;

public class Task3 {
    public static boolean isNestable(int[] arr1, int[] arr2) {
        if (arr2.length < 2) {
            return false;
        }

        if (arr1.length == 0) {
            return true;
        }
        int minArr1 = Integer.MAX_VALUE, minArr2 = Integer.MAX_VALUE,
            maxArr1 = Integer.MIN_VALUE, maxArr2 = Integer.MIN_VALUE;

        for (int num : arr1) {
            minArr1 = Math.min(minArr1, num);
            maxArr1 = Math.max(maxArr1, num);
        }

        for (int num : arr2) {
            minArr2 = Math.min(minArr2, num);
            maxArr2 = Math.max(maxArr2, num);
        }

        return (minArr2 < minArr1) && (maxArr1 < maxArr2);
    }
}
