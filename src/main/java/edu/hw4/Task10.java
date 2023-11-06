package edu.hw4;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task10 {
    public static List<Animal> getListWithDifferenceAgeAndCountPaws(List<Animal> zoo) {
        return zoo.stream()
            .filter(animal -> animal.paws() != animal.age())
            .collect(Collectors.toList());
    }
}
