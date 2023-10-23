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
import static edu.hw4.Task7.THERE_ARE_NO_SUITABLE_ANIMALS;
import static edu.hw4.Task8.getMoreHeavyAnimalAmongAnimalLowerThanK;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task8Test {
    @Test
    void test_get_heavy_animal_among_animal_lower_than_k(){
        Animal dog = new Animal("Sharik", DOG, M, 15, 100, 35, true);
        Animal cat = new Animal("Barsik", CAT, F, 13, 30, 4, true);
        Animal parrot = new Animal("Kesha", BIRD, M, 4,20 , 1, false);
        Animal shark = new Animal("Baby", FISH, F, 115, 200, 300, true);
        Animal digger = new Animal("Vasya", SPIDER, M, 1, 2, 1, true);
        List<Animal> zoo = new ArrayList<>(List.of(dog, cat, parrot, shark, digger));
        int k = 40;

        Animal resultAnimal = getMoreHeavyAnimalAmongAnimalLowerThanK(zoo, k);

        assertThat(resultAnimal).isEqualTo(cat);
    }

    @Test
    void throw_if_animal_lower_k_are_not_exist(){
        Animal dog = new Animal("Sharik", DOG, M, 15, 100, 35, true);
        Animal cat = new Animal("Barsik", CAT, F, 13, 30, 4, true);
        Animal parrot = new Animal("Kesha", BIRD, M, 4,20 , 1, false);
        Animal shark = new Animal("Baby", FISH, F, 115, 200, 300, true);
        Animal digger = new Animal("Vasya", SPIDER, M, 1, 2, 1, true);
        List<Animal> zoo = new ArrayList<>(List.of(dog, cat, parrot, shark, digger));
        int k = 2;

        var except = assertThrows(IndexOutOfBoundsException.class, () -> getMoreHeavyAnimalAmongAnimalLowerThanK(zoo, k));

        assertThat(except.getMessage()).isEqualTo(THERE_ARE_NO_SUITABLE_ANIMALS);
    }
}
