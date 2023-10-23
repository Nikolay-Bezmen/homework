package edu.hw4;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task13 {
    public static List<Animal> getAnimalsWhichHaveMoreThanTwoWordName(List<Animal> zoo) {
        return zoo.stream()
            .filter(animal -> animal.name().split(" ").length > 2)
            .collect(Collectors.toList());
    }
}
