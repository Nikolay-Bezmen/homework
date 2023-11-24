package edu.hw6.Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {
    public static final String ILLEGAL_FORMAT_DATE_IN_FILE = "illegal format date in file";
    private final Map<String, String> map;
    private final String path;

    public DiskMap(String path) {
        map = new HashMap<>();
        this.path = path;
    }

    public void getDateFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] dates = line.split(":");
                if (dates.length != 2) {
                    throw new RuntimeException(ILLEGAL_FORMAT_DATE_IN_FILE);
                }

                map.put(dates[0], dates[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            for (var e : map.entrySet()) {
                bw.write(e.getKey() + ":" + e.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override public int size() {
        return map.size();
    }

    @Override public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override public String get(Object key) {
        return map.get(key);
    }

    @Nullable @Override public String put(String key, String value) {
        return map.put(key, value);
    }

    @Override public String remove(Object key) {
        return map.remove(key);
    }

    @Override public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        map.putAll(m);
    }

    @Override public void clear() {
        map.clear();
    }

    @NotNull @Override public Set<String> keySet() {
        return map.keySet();
    }

    @NotNull @Override public Collection<String> values() {
        return map.values();
    }

    @NotNull @Override public Set<Entry<String, String>> entrySet() {
        return map.entrySet();
    }
}
