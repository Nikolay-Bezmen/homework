package edu.hw1;

import java.io.IOException;
import java.util.Arrays;

@SuppressWarnings("MagicNumber")
public class Task6 {
    public static final String INCORRECT_INPUT_DATA = "некоректные входные данные";

    public int countK(int num) throws IOException {
        int k = num;
        if (k % 1111 == 0 || k <= 1000 || k > 9999) {
            throw new IOException(INCORRECT_INPUT_DATA);
        }
        if (k == 6174) {
            return 0;
        }
        int[] numbs = new int[4];
        numbs[0] = k % 10;
        k /= 10;
        numbs[1] = k % 10;
        k /= 10;
        numbs[2] = k % 10;
        k /= 10;
        numbs[3] = k;
        Arrays.sort(numbs);
        int nextK = (numbs[3] * (1000) + numbs[2] * 100 + numbs[1] * 10 + numbs[0])
            - (numbs[0] * 1000 + numbs[1] * 100 + numbs[2] * 10 + numbs[3]);
        return 1 + countK(nextK);
    }
}
