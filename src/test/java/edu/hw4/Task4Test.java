package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static edu.hw4.Animal.Sex.F;
import static edu.hw4.Animal.Sex.M;
import static edu.hw4.Animal.Type.BIRD;
import static edu.hw4.Animal.Type.CAT;
import static edu.hw4.Animal.Type.DOG;
import static edu.hw4.Animal.Type.FISH;
import static edu.hw4.Animal.Type.SPIDER;
import static edu.hw4.Task4.LIST_IS_EMPTY;
import static edu.hw4.Task4.getAnimalWithMaxNam;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task4Test {
    @Test
    void test_zoo_sorted_type_than_sex_than_name() {
        Animal dog1 = new Animal("Sharik", DOG, M, 4, 100, 35, true);
        Animal cat = new Animal("Barsik", CAT, F, 15, 30, 4, true);
        Animal parrot = new Animal("Kesha", BIRD, M, 23, 20, 1, false);
        Animal dog2 = new Animal("Jack", DOG, M, 7, 100, 45, true);
        Animal shark = new Animal("Baby", FISH, F, 115, 200, 300, true);
        Animal dog3 = new Animal("Masha", DOG, F, 19, 100, 55, true);
        Animal digger = new Animal("Vasya", SPIDER, M, 1, 2, 1, true);
        Animal dog4 = new Animal("Tazik", DOG, M, 5, 100, 65, true);
        List<Animal> zoo = new ArrayList<>(List.of(dog1, cat, parrot, dog2, shark, dog3, digger, dog4));

        Animal resultOfFilter = getAnimalWithMaxNam(zoo);

        assertThat(resultOfFilter).isEqualTo(cat);
    }

    @Test
    void throws_if_list_of_animals_is_empty(){
        List<Animal> zoo = new ArrayList<>();

        var except = assertThrows(IndexOutOfBoundsException.class, () -> getAnimalWithMaxNam(zoo));

        assertThat(except.getMessage()).isEqualTo(LIST_IS_EMPTY);
    }
}
