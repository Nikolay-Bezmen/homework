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
import static edu.hw4.Task13.getAnimalsWhichHaveMoreThanTwoWordName;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task13Test {
    @Test
    void test_get_animals_which_have_more_than_two_word_name(){
        Animal dog1 = new Animal("Sharik Sharik", DOG, M, 4, 100, 35, true);
        Animal cat1 = new Animal("Barsik Barsik Barsik Barsik", CAT, M, 4, 30, 4, true);
        Animal parrot1 = new Animal("Kesha Kesha", BIRD, M, 4,20 , 1, false);
        Animal shark1 = new Animal("Baby", FISH, F, 115, 200, 300, true);
        Animal digger1 = new Animal("Vasya", SPIDER, M, 8, 2, 1, true);
        Animal dog2 = new Animal("Bobik Bobik Bobik", DOG, M, 4, 100, 35, true);
        Animal cat2 = new Animal("Murzik Ivan Sergeevich", CAT, M, 4, 30, 4, true);
        Animal parrot2= new Animal("Kesha", BIRD, M, 4,20 , 1, false);
        Animal shark2 = new Animal("Baby Baby Baby", FISH, F, 115, 200, 300, true);
        Animal digger2 = new Animal("Vasya", SPIDER, M, 8, 2, 1, true);
        List<Animal> zoo = List.of(dog1, cat1, parrot1, shark1, digger1,
            dog2, cat2, parrot2, shark2, digger2);
        List<Animal> correctFilter = List.of(cat1, dog2, cat2, shark2);

        List<Animal> resultOfFilter = getAnimalsWhichHaveMoreThanTwoWordName(zoo);

        assertThat(resultOfFilter).isEqualTo(correctFilter);
    }
}
