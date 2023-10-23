package edu.hw4;

import java.util.List;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task9 {
    public static int getCountPawsInZoo(List<Animal> zoo) {
        return zoo.stream()
            .map(Animal::paws)
            .reduce(0, Integer::sum);
    }
}
