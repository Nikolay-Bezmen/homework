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
import static edu.hw4.Task12.getAnimalsWhichHaveWeightMoreTheirHeight;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task12Test {
    @Test
    void test_get_animals_weight_more_than_hight(){
        Animal dog = new Animal("Sharik", DOG, M, 4, 100, 35, true);
        Animal cat = new Animal("Barsik", CAT, F, 4, 30, 4, true);
        Animal parrot = new Animal("Kesha", BIRD, M, 4,20 , 1, false);
        Animal shark = new Animal("Baby", FISH, F, 149, 200, 300, true);
        Animal whole1 = new Animal("Vasiliy", FISH, M, 115, 1000, 30000, false);
        Animal whole2 = new Animal("Victor", FISH, M, 146, 9876, 24358, false);
        Animal digger = new Animal("Vasya", SPIDER, M, 8, 2, 1, true);
        List<Animal> zoo = new ArrayList<>(List.of(dog, cat, parrot, whole2, shark, digger, whole1));
        Integer correctFilter = 3;

        Integer coutnOfFilter = getAnimalsWhichHaveWeightMoreTheirHeight(zoo);

        assertThat(coutnOfFilter).isEqualTo(correctFilter);
    }

}
