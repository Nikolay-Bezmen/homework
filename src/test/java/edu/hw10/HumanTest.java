package edu.hw10;

import edu.hw10.Task1.Human;
import edu.hw10.Task1.RandomObjectGenerator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HumanTest {
    @Test
    public void testHuman() {
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();
        Human human = randomObjectGenerator.nextObject(Human.class);

        assertThat(human.getAge()).isBetween(0, 100);
        assertThat(human.getName()).isNotNull();
        assertThat(human.getName()).isNotEmpty();
        assertThat(human.getWeight()).isBetween(5, 250);
    }
}
