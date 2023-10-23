package edu.hw4;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("HideUtilityClassConstructor")
public class Task4 {
    public static final String LIST_IS_EMPTY = "list of animals is empty";

    public static Animal getAnimalWithMaxNam(List<Animal> zoo) {
        Optional<Animal> animalWithMaxName = zoo.stream()
            .reduce((a, b) -> a.name().length() > b.name().length() ? a : b);

        if (animalWithMaxName.isEmpty()) {
            throw new IndexOutOfBoundsException(LIST_IS_EMPTY);
        }

        return animalWithMaxName.get();
    }
}
