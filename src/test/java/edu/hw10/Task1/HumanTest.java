package edu.hw10.Task1;

import edu.hw10.Task1.annotations.annotationExceptions.AnnotationsAreIncompatible;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HumanTest {
    @Test
    public void testHuman() throws AnnotationsAreIncompatible {
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();
        Human human = randomObjectGenerator.nextObject(Human.class);

        assertThat(human.getAge()).isBetween(0, 100);
        assertThat(human.getName()).isNotNull();
        assertThat(human.getName()).isNotEmpty();
        assertThat(human.getWeight()).isBetween(5, 250);
    }
}
