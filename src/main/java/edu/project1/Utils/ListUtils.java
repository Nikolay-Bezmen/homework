package edu.project1.Utils;

import java.util.List;

public class ListUtils {
    private ListUtils() {
    }

    public static String getRandomItem(List<String> list) {
        int indexOfRandomAccess = (int) System.currentTimeMillis() % (list.size());
        return list.get(indexOfRandomAccess);
    }
}
