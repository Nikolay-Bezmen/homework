package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.Animal.Sex.F;
import static edu.hw4.Animal.Sex.M;
import static edu.hw4.Animal.Type.BIRD;
import static edu.hw4.Animal.Type.CAT;
import static edu.hw4.Animal.Type.DOG;
import static edu.hw4.Animal.Type.FISH;
import static edu.hw4.Animal.Type.SPIDER;
import static edu.hw4.Task10.getListWithDifferenceAgeAndCountPaws;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task10Test {
    @Test
    void test_if_count_paws_and_age_of_animal_is_not_equal(){
        Animal dog = new Animal("Sharik", DOG, M, 4, 100, 35, true);
        Animal cat = new Animal("Barsik", CAT, F, 4, 30, 4, true);
        Animal parrot = new Animal("Kesha", BIRD, M, 4,20 , 1, false);
        Animal shark = new Animal("Baby", FISH, F, 115, 200, 300, true);
        Animal digger = new Animal("Vasya", SPIDER, M, 8, 2, 1, true);
        List<Animal> zoo = List.of(dog, cat, parrot, shark, digger);
        List<Animal> correctZoo = List.of(parrot, shark);

        List<Animal> resultOfFilter = getListWithDifferenceAgeAndCountPaws(zoo);

        assertThat(correctZoo).isEqualTo(resultOfFilter);
    }
}
