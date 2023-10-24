package edu.hw3;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task3 {
    public static Map<Object, Integer> freqDict(Object[] objects) {
        if (objects == null) {
            return new HashMap<>();
        }

        Map<Object, Integer> frequencyObjects = new HashMap<>();

        for (Object object : objects) {
            frequencyObjects.put(object, frequencyObjects.getOrDefault(object, 0) + 1);
        }

        return frequencyObjects;
    }
}
