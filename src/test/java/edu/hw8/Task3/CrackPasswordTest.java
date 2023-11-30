package edu.hw8.Task3;

import org.junit.jupiter.api.Test;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import static edu.hw8.Task3.MultiCrackPassword.BASE;
import static edu.hw8.Task3.MultiCrackPassword.calculateHash;
import static edu.hw8.Task3.MultiCrackPassword.nextPermutation;
import static edu.hw8.Task3.MultiCrackPassword.startCracking;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CrackPasswordTest {
    @Test
    void test_that_for_each_password_always_exist_only_one_hash() throws NoSuchAlgorithmException {
        String password = "niefn73jwn8";
        String firstHash = calculateHash(password);
        String secondHash = calculateHash(password);

        assertThat(firstHash).isEqualTo(secondHash);
    }

    @Test
    void test_correct_next_permutation_if_without_passing_through_discharges(){
        //the number system with a base equals 36
        int[] currPermutation = {1,5,8,3,7,9};
        int[] correctNextPermutation = {1,5,8,3,7,10};

        boolean hasNextPermutation = nextPermutation(currPermutation);

        assertThat(hasNextPermutation).isTrue();
        assertThat(currPermutation).isEqualTo(correctNextPermutation);
    }


    @Test
    void test_correct_next_permutation_if_we_founded_on_transfer_through_discharges(){
        int[] currPermutation = {1,5,8,3,7,35};
        int[] correctNextPermutation = {1,5,8,3,8,0};

        boolean hasNextPermutation = nextPermutation(currPermutation);

        assertThat(hasNextPermutation).isTrue();
        assertThat(currPermutation).isEqualTo(correctNextPermutation);
    }

    @Test
    void test_if_next_permutation_is_not_exist(){
        int[] currPermutation = {BASE - 1, BASE - 1, BASE -1};

        assertThat(nextPermutation(currPermutation)).isFalse();
    }

    @Test
    void test_correct_crack_some_password() throws InterruptedException {
        Map<String, String> hashToUser = Map.of(
            "fa246d0262c3925617b0c72bb20eeb1d", "userA",
            "9714ce22cb8a26b5de87bfc1d45b3905", "userB",
            "ff7bfe66f6c705c824c4dd83fcfaa660", "userC",
            "45c48cce2e2d7fbdea1afc51c7c6ad26", "userD",
            "d448c3aca64b30cd9bb9408caec87ee3", "userE",
            "9cdfb439c7876e703e307864c9167a15", "userF",
            "8f5f0a21dccba1517eb460159f304a83", "userG",
            "81dc9bdb52d04dc20036dbd8313ed055", "userH",
            "acbf94a2ca2cc3a256687952056ea537", "userI",
            "1af89a12b7b08f50b674654bb2f5c5d7", "userJ"
        );

        Map<String, String> correctPasswords = Map.of(
            "userA", "9999",
            "userB", "69pr",
            "userC", "hd8k",
            "userD","9",
            "userE","j0sl",
            "userF","lol",
            "userG","kddk",
            "userH","1234",
            "userI","jdi",
            "userJ", "lf0"
        );

        assertThat(startCracking(hashToUser, -1)).isEqualTo(correctPasswords);
    }

    @Test
    void test_that_multi_threads_faster_than_single_thread() throws InterruptedException, NoSuchAlgorithmException {
        long startMulti = System.currentTimeMillis();
        MultiCrackPassword.startCracking(new HashMap<>(), -1);
        long multiProcessTime = System.currentTimeMillis() - startMulti;

        long singleStart = System.currentTimeMillis();
        SingleCrackPassword.startCracking(new HashMap<>(), -1);
        long singleStartTime = System.currentTimeMillis() - singleStart;

        assertThat(multiProcessTime).isLessThan(singleStartTime);

    }
}
