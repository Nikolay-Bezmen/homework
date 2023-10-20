package edu.project1.GameSessionTest;

import edu.project1.GameSession.Dictionary;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DictionaryTest {
    @Test
    void chech_if_dictionary_is_contained(){
        boolean contains = Dictionary.getSetWords().contains(Dictionary.getRandomWord());

        assertThat(contains).isTrue();
    }
}
