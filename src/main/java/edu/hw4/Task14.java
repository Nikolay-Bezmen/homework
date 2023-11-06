package edu.hw4;

import java.util.List;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task14 {
    public static boolean haveDogsWithHightMoreThanK(List<Animal> zoo, int k) {
        return zoo.stream()
            .filter(animal -> animal.type().equals(Animal.Type.DOG))
            .anyMatch(animal -> animal.height() > k);
    }
}
