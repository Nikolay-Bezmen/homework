package edu.hw4;

import java.util.List;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task15 {
    public static Integer getSumWeightsForAnimalsWhithAgeFromKtoL(List<Animal> zoo, int k, int l) {
        return zoo.stream()
            .filter(animal -> animal.age() >= k && animal.age() <= l)
            .mapToInt(Animal::weight)
            .sum();
    }
}
