package edu.Project2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;
import static edu.Project2.DFSSolver.COORDINATE_INCORRECT;
import static edu.Project2.DFSSolver.DFS;
import static edu.Project2.OldosBroaderGenerate.OLDOS_BROADER_GENERATE;
import static edu.Project2.WilsonGenerate.WILSON_GENERATE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Disabled
public class DFSSolverTest {
    Maze maze;
    @Test
    void test_find_path_dfs() throws InterruptedException {
        int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        maze = new Maze(60, 30, WILSON_GENERATE, true);
        List<int[]> path = maze.getMinPath(1, 1, 31, 61, DFS);

        for (int i = 0; i < path.size() - 1; ++i) {
            int x = path.get(i)[0], y = path.get(i)[1];
            int nextX = path.get(i + 1)[0], nextY = path.get(i + 1)[1];
            boolean cellsIsNeighbors = false;

            for (int[] direction : directions) {
                if (x + direction[0] == nextX && y + direction[1] == nextY) {
                    cellsIsNeighbors = true;
                    break;
                }
            }

            assertThat(cellsIsNeighbors).isTrue();
        }
        maze.printMaze(2500);
        assertThat(path.get(path.size() - 1)[0]).isEqualTo(61);
        assertThat(path.get(path.size() - 1)[1]).isEqualTo(31);
    }

    @Test
    void test_correct_start_and_end_of_path() throws InterruptedException {
        maze = new Maze(40, 10, WILSON_GENERATE, false);
        List<int[]> path = maze.getMinPath(1, 1, 11, 41, DFS);

        assertThat(path.get(0)[0]).isEqualTo(1);
        assertThat(path.get(0)[1]).isEqualTo(1);
        assertThat(path.get(path.size() - 1)[0]).isEqualTo(41);
        assertThat(path.get(path.size() - 1)[1]).isEqualTo(11);
    }

    @ParameterizedTest
    @MethodSource("getInvalidCoordinatesForDFS")
    void throw_if_coordinates_is_not_correct(int x1, int y1, int x2, int y2) throws InterruptedException {
        maze = new Maze(30, 30, OLDOS_BROADER_GENERATE, false);
        var except = assertThrows(
            IllegalArgumentException.class,
            () -> maze.getMinPath(x1, y1, x2, y2, DFS)
        );
        assertThat(except.getMessage()).isEqualTo(COORDINATE_INCORRECT);
    }

    private static Stream<Arguments> getInvalidCoordinatesForDFS() {
        return Stream.of(
            Arguments.of(-1, 2, 2, 2),
            Arguments.of(2, -1, 2, 2),
            Arguments.of(2, 2, -1, 2),
            Arguments.of(2, 2, 2, -1),
            Arguments.of(32, 2, 2, 2),
            Arguments.of(2, 34, 2, 2),
            Arguments.of(2, 2, 34, 2),
            Arguments.of(2, 2, 2, 233)
        );
    }
}
