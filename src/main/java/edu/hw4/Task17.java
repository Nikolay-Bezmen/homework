package edu.hw4;

import java.util.List;
import static edu.hw4.Animal.Type.DOG;
import static edu.hw4.Animal.Type.SPIDER;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task17 {
    public static boolean spidersBitesMoreOftenThanDogs(List<Animal> zoo) {


        double frequencyBitesForDogs = (double)             zoo.stream()
            .filter(animal -> animal.type() == DOG && animal.bites())
            .count()
            /
            zoo.stream()
            .filter(animal -> animal.type() == DOG)
            .count();

        double frequencyBitesForSpiders = (double)             zoo.stream()
            .filter(animal -> animal.type() == SPIDER && animal.bites())
            .count()
            /
            zoo.stream()
                .filter(animal -> animal.type() == SPIDER)
                .count();

        return frequencyBitesForSpiders > frequencyBitesForDogs;
    }
}
