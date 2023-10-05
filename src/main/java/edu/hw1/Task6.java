package edu.hw1;

import java.io.IOException;
import java.util.Arrays;

public class Task6 {

    public int countK(int num) throws IOException {
        final int oneThousand = 1000;
        final int nineX4 = 9999;
        final int oneX4 = 1111;
        final int constOfKaprekar = 6174;
        final int ten = 10;
        final int one = 1;
        final int zero = 0;
        final int two = 2;
        final int three = 3;
        final int four = 4;
        int k = num;
        if (k % oneX4 == zero || k < oneThousand || k > nineX4) {
            throw new IOException("некоректные входные данные");
        }
        if (k == constOfKaprekar) {
            return zero;
        }
        int[] nums = new int[four];
        nums[zero] = k % ten;
        k /= ten;
        nums[one] = k % ten;
        k /= ten;
        nums[two] = k % ten;
        k /= ten;
        nums[three] = k;
        Arrays.sort(nums);
        int nextK = (nums[three] * (oneThousand) + nums[two] * ten * ten + nums[one] * ten + nums[zero])
            - (nums[zero] * oneThousand + nums[one] * ten * ten + nums[two] * ten + nums[three]);
        return one + countK(nextK);
    }
}
