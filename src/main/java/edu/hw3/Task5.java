package edu.hw3;

import java.util.Arrays;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task5 {
    public static final String IS_NOT_EXIST_SO_COMPARATOR = "this compare is not exist";
    public static final String ASC = "ASC";
    public static final String DESC = "DESC";

    public static String[] parseContacts(String[] contacts, String comparator) throws IllegalArgumentException {
        if (comparator.equals(ASC)) {
            if (contacts == null) {
                return new String[] {};
            }

            Arrays.sort(contacts, Task5::comparatorASC);
        } else if (comparator.equals(DESC)) {
            if (contacts == null) {
                return new String[] {};
            }

            Arrays.sort(contacts, Task5::comparatorDESC);
        } else {
            throw new IllegalArgumentException(IS_NOT_EXIST_SO_COMPARATOR);
        }

        return contacts;
    }

    private static int comparatorDESC(String a, String b) {
        String[] fullNameA = a.split(" ");
        String[] fullNameB = b.split(" ");
        String first = fullNameA.length >= 2 ? fullNameA[1] : fullNameA[0];
        String second = fullNameB.length >= 2 ? fullNameB[1] : fullNameB[0];

        return second.compareTo(first);
    }

    private static int comparatorASC(String a, String b) {
        return comparatorDESC(b, a);
    }
}
