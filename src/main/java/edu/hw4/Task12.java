package edu.hw4;

import java.util.List;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task12 {
    public static Integer getAnimalsWhichHaveWeightMoreTheirHeight(List<Animal> zoo) {
        return (int) zoo.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count();
    }
}
