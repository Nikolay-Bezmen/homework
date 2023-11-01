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
import static edu.hw4.Task17.spidersBitesMoreOftenThanDogs;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task17Test {
    @Test
    void test_check_if_spiders_bites_more_often_than_dogs(){
        Animal dog1 = new Animal("Sharik1", DOG, M, 15, 100, 35, true);
        Animal dog2 = new Animal("Sharik2", DOG, F, 15, 100, 35, true);
        Animal dog3 = new Animal("Sharik3", DOG, M, 15, 100, 35, true);
        Animal dog4 = new Animal("Sharik4", DOG, M, 15, 100, 35, false);
        Animal dog5 = new Animal("Sharik1", DOG, M, 15, 100, 35, false);
        Animal dog6 = new Animal("Sharik2", DOG, F, 15, 100, 35, false);
        Animal dog7 = new Animal("Sharik3", DOG, M, 15, 100, 35, false);
        Animal dog8 = new Animal("Sharik4", DOG, M, 15, 100, 35, true);
        Animal cat = new Animal("Barsik1", CAT, F, 13, 30, 4, true);
        Animal parrot = new Animal("Kesha1", BIRD, F, 4,20 , 1, false);
        Animal shark = new Animal("Baby7", FISH, F, 115, 200, 300, true);
        Animal digger1 = new Animal("Vasya", SPIDER, M, 1, 1, 1, true);
        Animal digger2 = new Animal("Vasya", SPIDER, M, 1, 1, 1, true);
        Animal digger3 = new Animal("Vasya", SPIDER, M, 1, 1, 1, true);
        Animal digger4 = new Animal("Vasya", SPIDER, M, 1, 1, 1, false);
        Animal digger5 = new Animal("Vasya", SPIDER, M, 1, 1, 1, false);
        List<Animal> zoo = List.of(
           dog1, dog2, dog3, dog4, dog5, dog6, dog7, dog8,
            cat,
            parrot,
            shark,
            digger1, digger2, digger3, digger4, digger5
        );
        //frequencyForDogs = 4/8 = 0.5;
        //frequencyForSpiders = 3/5 = 0.6
        // 0.6 > 0.5 => true
        boolean correctResult = true;

        boolean resultOfWork = spidersBitesMoreOftenThanDogs(zoo);

        assertThat(resultOfWork).isEqualTo(correctResult);
    }

    @Test
    void test_check_if_spiders_bites_not_more_often_than_dogs(){
        Animal dog1 = new Animal("Sharik1", DOG, M, 15, 100, 35, true);
        Animal dog2 = new Animal("Sharik2", DOG, F, 15, 100, 35, true);
        Animal dog3 = new Animal("Sharik3", DOG, M, 15, 100, 35, true);
        Animal dog4 = new Animal("Sharik4", DOG, M, 15, 100, 35, false);
        Animal dog5 = new Animal("Sharik1", DOG, M, 15, 100, 35, false);
        Animal dog6 = new Animal("Sharik2", DOG, F, 15, 100, 35, false);
        Animal dog7 = new Animal("Sharik3", DOG, M, 15, 100, 35, false);
        Animal dog8 = new Animal("Sharik4", DOG, M, 15, 100, 35, true);
        Animal cat = new Animal("Barsik1", CAT, F, 13, 30, 4, true);
        Animal parrot = new Animal("Kesha1", BIRD, F, 4,20 , 1, false);
        Animal shark = new Animal("Baby7", FISH, F, 115, 200, 300, true);
        Animal digger1 = new Animal("Vasya", SPIDER, M, 1, 1, 1, true);
        Animal digger2 = new Animal("Vasya", SPIDER, M, 1, 1, 1, true);
        Animal digger3 = new Animal("Vasya", SPIDER, M, 1, 1, 1, false);
        Animal digger4 = new Animal("Vasya", SPIDER, M, 1, 1, 1, false);
        Animal digger5 = new Animal("Vasya", SPIDER, M, 1, 1, 1, false);
        List<Animal> zoo = List.of(
            dog1, dog2, dog3, dog4, dog5, dog6, dog7, dog8,
            cat,
            parrot,
            shark,
            digger1, digger2, digger3, digger4, digger5
        );
        //frequencyForDogs = 4/8 = 0.5;
        //frequencyForSpiders = 2/5 = 0.4
        // 0.5 > 0.4 => true
        boolean correctResult = false;

        boolean resultOfWork = spidersBitesMoreOftenThanDogs(zoo);

        assertThat(resultOfWork).isEqualTo(correctResult);
    }
}
