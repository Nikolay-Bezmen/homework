package edu.hw4;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings({"HideUtilityClassConstructor", "MagicNumber"})
public class Task11 {
    public static List<Animal> getAnimalWhichCanBiteAndHaveHeightMoreOneMeter(List<Animal> zoo) {
        return zoo.stream()
            .filter(animal -> !animal.bites())
            .filter(animal -> animal.height() > 100)
            .collect(Collectors.toList());
    }
}
