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
import static edu.hw4.Task14.haveDogsWithHightMoreThanK;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task14Test {
    @Test
    void test_if_zoo_have_dog_with_hight_more_than_k() {
        Animal dog1 = new Animal("Sharik", DOG, M, 4, 100, 35, true);
        Animal cat = new Animal("Barsik", CAT, F, 4, 30, 4, true);
        Animal parrot = new Animal("Kesha", BIRD, M, 4, 20, 1, false);
        Animal dog2 = new Animal("Jack", DOG, M, 4, 100, 45, true);
        Animal shark = new Animal("Baby", FISH, F, 115, 200, 300, true);
        Animal dog3 = new Animal("Marik", DOG, M, 4, 100, 55, true);
        Animal digger = new Animal("Vasya", SPIDER, M, 8, 2, 1, true);
        Animal dog4 = new Animal("Tazik", DOG, M, 4, 100, 65, true);
        List<Animal> zoo = List.of(dog1, cat, parrot, dog2, shark, dog3, digger, dog4);
        int k = 60;
        boolean correctResult = true;

        boolean resultOfWork = haveDogsWithHightMoreThanK(zoo, k);

        assertThat(resultOfWork).isEqualTo(correctResult);
    }

    @Test
    void test_if_zoo_have_not_dog_with_hight_more_than_k() {
        Animal dog1 = new Animal("Sharik", DOG, M, 4, 100, 35, true);
        Animal cat = new Animal("Barsik", CAT, F, 4, 30, 4, true);
        Animal parrot = new Animal("Kesha", BIRD, M, 4, 20, 1, false);
        Animal dog2 = new Animal("Jack", DOG, M, 4, 100, 45, true);
        Animal shark = new Animal("Baby", FISH, F, 115, 200, 300, true);
        Animal dog3 = new Animal("Marik", DOG, M, 4, 100, 55, true);
        Animal digger = new Animal("Vasya", SPIDER, M, 8, 2, 1, true);
        Animal dog4 = new Animal("Tazik", DOG, M, 4, 100, 65, true);
        List<Animal> zoo = List.of(dog1, cat, parrot, dog2, shark, dog3, digger, dog4);
        int k = 110;
        boolean correctResult = false;

        boolean resultOfWork = haveDogsWithHightMoreThanK(zoo, k);

        assertThat(resultOfWork).isEqualTo(correctResult);
    }
}
