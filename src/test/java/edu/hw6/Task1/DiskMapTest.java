package edu.hw6.Task1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class DiskMapTest {
    private static String pathToDiskMap;

    @BeforeAll static void setup() throws IOException {
        pathToDiskMap = "diskMapFile.txt";
        Files.createFile(Path.of(pathToDiskMap));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathToDiskMap))) {
            for (int i = 0; i < 10; ++i) {
                bw.write(("key" + i + ":value" + i));
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void test_correct_get_date_from_file_without_exceptions() {
        DiskMap diskMap = new DiskMap(pathToDiskMap);

        assertDoesNotThrow(diskMap::getDateFromFile);
    }

    @Test
    void test_is_empty_method() {
        DiskMap diskMap = new DiskMap(pathToDiskMap);

        assertThat(diskMap.isEmpty()).isTrue();
    }

    @Test
    void test_correct_save_to_file_and_than_correct_get_date_from_him() {
        DiskMap diskMap = new DiskMap(pathToDiskMap);
        diskMap.put("key11", "value11");
        diskMap.put("key12", "value12");
        diskMap.saveToFile();
        diskMap.clear();

        assertDoesNotThrow(diskMap::getDateFromFile);
        assertThat(diskMap.containsKey("key11")).isTrue();
        assertThat(diskMap.containsKey("key12")).isTrue();
    }

    @Test
    void test_size_method() {
        DiskMap diskMap = new DiskMap(pathToDiskMap);
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");

        int correctSize = 2;

        assertThat(diskMap.size()).isEqualTo(correctSize);
    }

    @Test
    void test_contains_key_from_file() {
        DiskMap diskMap = new DiskMap(pathToDiskMap);
        diskMap.getDateFromFile();
        String mustBeContainsKey = "key1";

        assertThat(diskMap.containsKey(mustBeContainsKey)).isTrue();
    }

    @Test
    void test_contains_key() {
        DiskMap diskMap = new DiskMap(pathToDiskMap);
        diskMap.put("key1", "value1");

        assertThat(diskMap.containsKey("key1")).isTrue();
    }

    @Test
    void test_contains_value_from_file() {
        DiskMap diskMap = new DiskMap(pathToDiskMap);
        diskMap.getDateFromFile();
        String mustBeContainsValue = "value1";

        assertThat(diskMap.containsValue(mustBeContainsValue)).isTrue();
    }

    @Test
    void test_contains_value() {
        DiskMap diskMap = new DiskMap(pathToDiskMap);
        diskMap.put("key11", "value11");

        assertThat(diskMap.containsValue("value11")).isTrue();
    }

    @Test
    void test_get_method() {
        DiskMap diskMap = new DiskMap(pathToDiskMap);
        String key = "key";
        String correctValue = "value";
        diskMap.put(key, "value");

        assertThat(diskMap.get(key)).isEqualTo(correctValue);
    }

    @Test
    void test_put_method() {
        DiskMap diskMap = new DiskMap(pathToDiskMap);
        String key = "key";
        String value = "value";
        diskMap.put(key, value);

        assertThat(diskMap.containsKey(key)).isTrue();
        assertThat(diskMap.containsValue(value)).isTrue();
    }

    @Test
    void test_remove_method() {
        DiskMap diskMap = new DiskMap(pathToDiskMap);
        String key = "key";
        String value = "value";
        diskMap.put(key, value);

        diskMap.remove(key);

        assertThat(diskMap.containsKey(key)).isFalse();
    }

    @Test
    void test_clear_method() {
        DiskMap diskMap = new DiskMap(pathToDiskMap);
        diskMap.getDateFromFile();

        diskMap.clear();

        assertThat(diskMap.isEmpty()).isTrue();
    }

    @Test
    void test_putAll_method() {
        Map<String, String> map = Map.of(
            "key1", "value1",
            "key2", "value2",
            "key4", "value4"
        );

        DiskMap diskMap = new DiskMap(pathToDiskMap);
        diskMap.putAll(map);

        for (String key : map.keySet()) {
            assertThat(diskMap.containsKey(key)).isTrue();
        }
    }

    @Test
    void test_keySet_method() {
        Map<String, String> map = Map.of(
            "key1", "value1",
            "key2", "value2",
            "key4", "value4"
        );

        DiskMap diskMap = new DiskMap(pathToDiskMap);
        diskMap.putAll(map);

        assertThat(diskMap.keySet()).isEqualTo(map.keySet());
    }

    @Test
    void test_values_method() {
        Map<String, String> map = Map.of(
            "key1", "value1",
            "key2", "value2",
            "key4", "value4"
        );

        DiskMap diskMap = new DiskMap(pathToDiskMap);
        diskMap.putAll(map);

        assertThat(new HashSet<>(diskMap.values()))
            .isEqualTo(new HashSet<>(map.values()));
    }

    @Test
    void test_entrySet_method() {
        Map<String, String> map = Map.of(
            "key1", "value1",
            "key2", "value2",
            "key4", "value4"
        );

        DiskMap diskMap = new DiskMap(pathToDiskMap);
        diskMap.putAll(map);

        assertThat(diskMap.entrySet()).isEqualTo(map.entrySet());
    }

    @AfterAll static void clear() throws IOException {
        Files.deleteIfExists(Path.of(pathToDiskMap));
    }
}
