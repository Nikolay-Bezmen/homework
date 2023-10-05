package edu.hw1;

import java.io.IOException;
import java.util.Arrays;

public class Task6 {
    public int countK(int K) throws IOException {
        if (K % 1111 == 0 || K < 1000 || K > 9999) {
            throw new IOException("некоректные входные данные");
        }
        if (K == 6174) {
            return 0;
        }
        int[] nums = new int[4];
        nums[0] = K % 10;
        K /= 10;
        nums[1] = K % 10;
        K /= 10;
        nums[2] = K % 10;
        K /= 10;
        nums[3] = K;
        Arrays.sort(nums);
        int nextK = (nums[3] * 1000 + nums[2] * 100 + nums[1] * 10 + nums[0]) -
            (nums[0] * 1000 + nums[1] * 100 + nums[2] * 10 + nums[3]);
        return 1 + countK(nextK);
    }
}
