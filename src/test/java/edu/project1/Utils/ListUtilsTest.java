package edu.project1.Utils;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ListUtilsTest {
    @Test
    void test_random_access_to_list() {
        List<String> dictionary = List.of("banana", "chocolate", "coffee", "apple", "horse");
        String word = ListUtils.getRandomItem(dictionary);

        assertThat(dictionary.contains(word)).isTrue();
    }
}
