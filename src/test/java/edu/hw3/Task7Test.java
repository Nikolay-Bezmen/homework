package edu.hw3;

import edu.hw3.Task7.TreeMapComparator;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    void test_if_tree_map_contains_key_null() {
        TreeMap<String, String> treeMap = new TreeMap<>(new TreeMapComparator());

        treeMap.put(null, "test");
        boolean result = treeMap.containsKey(null);

        assertThat(result).isTrue();
    }
}
