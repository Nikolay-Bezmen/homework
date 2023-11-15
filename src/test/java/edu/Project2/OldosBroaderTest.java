package edu.Project2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OldosBroaderTest {
    @Test
    void test_oldos_broader_return_not_null_matrix() {
        char[][] matrixOfMaze = new OldosBroaderGenerate(60, 30).generate();

        assertThat(matrixOfMaze).isNotEmpty();
    }

    @Test
    void test_oldos_broader_return_matrix_curtain_size() {
        int correctHeight = 63;
        int correctWidth = 33;

        char[][] matrixOfMaze = new OldosBroaderGenerate(60, 30).generate();
        int resultHeight = matrixOfMaze.length;
        int resultOfWidth = matrixOfMaze[0].length;

        assertThat(resultHeight).isEqualTo(correctHeight);
        assertThat(resultOfWidth).isEqualTo(correctWidth);
    }
}
