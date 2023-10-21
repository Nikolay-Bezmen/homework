package edu.hw3;

import edu.hw3.Task8.BackwardIterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static edu.hw3.Task8.BackwardIterator.HAS_NOT_NEXT_ELEMENT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task8Test {
    List<Integer> list;

    @BeforeEach
    void set_up() {
        list = new ArrayList<>();

        list.add(3);
        list.add(2);
        list.add(1);

    }

    @Test
    void test_backward_iterator() {
        BackwardIterator<Integer> backwardIterator = new BackwardIterator<>(list);

        int i = list.size();
        while (backwardIterator.hasNext()) {
            int currElement = backwardIterator.next();
            int correctCurrElement = list.get(--i);

            assertThat(currElement).isEqualTo(correctCurrElement);
        }
    }

    @Test
    void throws_if_has_not_next_element() {
        BackwardIterator<Integer> backwardIterator = new BackwardIterator<>(list);

        for (int i = 0; i < list.size(); ++i) {
            backwardIterator.next();
        }

        var except = assertThrows(IndexOutOfBoundsException.class, backwardIterator::next);

        assertThat(except.getMessage()).isEqualTo(HAS_NOT_NEXT_ELEMENT);
    }
}
