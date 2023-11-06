package edu.Project2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static edu.Project2.BFSSolver.BFS;
import static edu.Project2.DFSSolver.COORDINATE_INCORRECT;
import static edu.Project2.DFSSolver.DFS;
import static edu.Project2.OldosBroaderGenerate.OLDOS_BROADER_GENERATE;
import static edu.Project2.WilsonGenerate.WILSON_GENERATE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BFSSolverTest {
    private final char[][] matrix = {
        {497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497,
            497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497},
        {497, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 78, 32, 32, 32, 32,
            32, 32, 32, 78, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 497},
        {497, 32, 78, 78, 78, 78, 78, 78, 78, 78, 78, 32, 78, 32, 78, 78, 78,
            32, 78, 78, 78, 32, 78, 78, 78, 78, 78, 32, 78, 78, 78, 78, 497},
        {497, 32, 78, 32, 32, 32, 78, 32, 32, 32, 32, 32, 78, 32, 32, 32, 78,
            32, 32, 32, 78, 32, 32, 32, 78, 32, 32, 32, 78, 32, 32, 32, 497},
        {497, 32, 78, 32, 78, 32, 78, 78, 78, 78, 78, 32, 78, 78, 78, 78, 78,
            78, 78, 32, 78, 78, 78, 32, 78, 32, 78, 32, 78, 32, 78, 32, 497},
        {497, 32, 32, 32, 78, 32, 78, 32, 32, 32, 78, 32, 32, 32, 32, 32, 32,
            32, 32, 32, 78, 32, 32, 32, 78, 32, 78, 32, 78, 32, 78, 32, 497},
        {497, 32, 78, 78, 78, 32, 78, 32, 78, 32, 78, 78, 78, 78, 78, 78, 78,
            78, 78, 78, 78, 32, 78, 78, 78, 32, 78, 78, 78, 32, 78, 32, 497},
        {497, 32, 78, 32, 32, 32, 78, 32, 78, 32, 32, 32, 32, 32, 32, 32, 32,
            32, 78, 32, 32, 32, 32, 32, 78, 32, 32, 32, 32, 32, 78, 32, 497},
        {497, 32, 78, 32, 78, 78, 78, 32, 78, 78, 78, 78, 78, 78, 78, 78, 78,
            32, 78, 32, 78, 78, 78, 78, 78, 78, 78, 78, 78, 78, 78, 32, 497},
        {497, 32, 78, 32, 32, 32, 78, 32, 78, 32, 32, 32, 32, 32, 32, 32, 78,
            32, 78, 32, 78, 32, 78, 32, 32, 32, 32, 32, 32, 32, 32, 32, 497},
        {497, 32, 78, 78, 78, 32, 78, 32, 78, 32, 78, 78, 78, 78, 78, 32, 78,
            32, 78, 32, 78, 32, 78, 32, 78, 78, 78, 78, 78, 78, 78, 32, 497},
        {497, 32, 32, 32, 78, 32, 32, 32, 78, 32, 78, 32, 32, 32, 32, 32, 78,
            32, 32, 32, 78, 32, 78, 32, 32, 32, 32, 32, 78, 32, 32, 32, 497},
        {497, 78, 78, 32, 78, 78, 78, 78, 78, 32, 78, 78, 78, 78, 78, 78, 78,
            78, 78, 78, 78, 32, 78, 78, 78, 78, 78, 32, 78, 32, 78, 78, 497},
        {497, 32, 78, 32, 32, 32, 32, 32, 78, 32, 32, 32, 32, 32, 32, 32, 32,
            32, 32, 32, 32, 32, 32, 32, 32, 32, 78, 32, 78, 32, 32, 32, 497},
        {497, 32, 78, 78, 78, 78, 78, 32, 78, 78, 78, 78, 78, 78, 78, 78, 78,
            32, 78, 78, 78, 78, 78, 78, 78, 78, 78, 32, 78, 78, 78, 32, 497},
        {497, 32, 32, 32, 32, 32, 78, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32,
            32, 78, 32, 32, 32, 32, 32, 32, 32, 78, 32, 78, 32, 78, 32, 497},
        {497, 32, 78, 78, 78, 32, 78, 32, 78, 78, 78, 78, 78, 78, 78, 78, 78,
            78, 78, 32, 78, 78, 78, 78, 78, 32, 78, 32, 78, 32, 78, 32, 497},
        {497, 32, 32, 32, 78, 32, 78, 32, 78, 32, 32, 32, 32, 32, 32, 32, 32,
            32, 78, 32, 78, 32, 78, 32, 32, 32, 32, 32, 78, 32, 32, 32, 497},
        {497, 32, 78, 78, 78, 32, 78, 32, 78, 32, 78, 78, 78, 78, 78, 78, 78,
            32, 78, 32, 78, 32, 78, 32, 78, 78, 78, 78, 78, 78, 78, 78, 497},
        {497, 32, 78, 32, 32, 32, 78, 32, 78, 32, 78, 32, 32, 32, 32, 32, 78,
            32, 32, 32, 78, 32, 78, 32, 32, 32, 78, 32, 32, 32, 32, 32, 497},
        {497, 78, 78, 32, 78, 32, 78, 32, 78, 32, 78, 78, 78, 32, 78, 78, 78,
            78, 78, 78, 78, 32, 78, 78, 78, 32, 78, 32, 78, 78, 78, 32, 497},
        {497, 32, 32, 32, 78, 32, 78, 32, 78, 32, 32, 32, 78, 32, 32, 32, 32,
            32, 32, 32, 78, 32, 32, 32, 32, 32, 78, 32, 78, 32, 78, 32, 497},
        {497, 32, 78, 32, 78, 78, 78, 32, 78, 78, 78, 32, 78, 78, 78, 32, 78,
            78, 78, 78, 78, 32, 78, 78, 78, 78, 78, 32, 78, 32, 78, 32, 497},
        {497, 32, 78, 32, 78, 32, 32, 32, 78, 32, 78, 32, 78, 32, 32, 32, 78,
            32, 32, 32, 32, 32, 78, 32, 32, 32, 78, 32, 78, 32, 78, 32, 497},
        {497, 32, 78, 32, 78, 32, 78, 78, 78, 32, 78, 32, 78, 32, 78, 78, 78,
            32, 78, 78, 78, 78, 78, 32, 78, 32, 78, 32, 78, 32, 78, 32, 497},
        {497, 32, 78, 32, 78, 32, 78, 32, 32, 32, 78, 32, 78, 32, 32, 32, 32,
            32, 32, 32, 32, 32, 78, 32, 78, 32, 78, 32, 78, 32, 78, 32, 497},
        {497, 32, 78, 78, 78, 32, 78, 32, 78, 32, 78, 32, 78, 78, 78, 78, 78,
            78, 78, 78, 78, 78, 78, 32, 78, 32, 78, 32, 78, 32, 78, 32, 497},
        {497, 32, 78, 32, 32, 32, 78, 32, 78, 32, 78, 32, 32, 32, 32, 32, 78,
            32, 32, 32, 32, 32, 78, 32, 78, 32, 32, 32, 78, 32, 32, 32, 497},
        {497, 32, 78, 32, 78, 78, 78, 32, 78, 32, 78, 78, 78, 78, 78, 32, 78,
            32, 78, 78, 78, 32, 78, 32, 78, 78, 78, 78, 78, 32, 78, 78, 497},
        {497, 32, 32, 32, 78, 32, 32, 32, 78, 32, 78, 32, 32, 32, 78, 32, 78,
            32, 32, 32, 78, 32, 78, 32, 32, 32, 32, 32, 78, 32, 32, 32, 497},
        {497, 32, 78, 78, 78, 78, 78, 32, 78, 32, 78, 78, 78, 32, 78, 32, 78,
            78, 78, 32, 78, 32, 78, 78, 78, 78, 78, 78, 78, 78, 78, 32, 497},
        {497, 32, 32, 32, 32, 32, 32, 32, 78, 32, 32, 32, 32, 32, 78, 32, 32,
            32, 32, 32, 78, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 497},
        {497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497,
            497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497, 497}
    };

    @Test
    void test_find_path() throws InterruptedException {
        List<int[]> correctPath = List.of(
            new int[] {1, 1}, new int[] {1, 2}, new int[] {1, 3}, new int[] {1, 4}, new int[] {1, 5},
            new int[] {2, 5}, new int[] {3, 5}, new int[] {3, 4}, new int[] {3, 3}, new int[] {4, 3},
            new int[] {5, 3}, new int[] {5, 4}, new int[] {5, 5}, new int[] {5, 6}, new int[] {5, 7},
            new int[] {4, 7}, new int[] {3, 7}, new int[] {3, 8}, new int[] {3, 9}, new int[] {4, 9},
            new int[] {5, 9}, new int[] {5, 10}, new int[] {5, 11}, new int[] {6, 11}, new int[] {7, 11},
            new int[] {7, 10}, new int[] {7, 9}, new int[] {7, 8}, new int[] {7, 7}, new int[] {7, 6},
            new int[] {7, 5}, new int[] {8, 5}, new int[] {9, 5}, new int[] {9, 6}, new int[] {9, 7},
            new int[] {10, 7}, new int[] {11, 7}, new int[] {12, 7}, new int[] {13, 7}, new int[] {14, 7},
            new int[] {15, 7}, new int[] {16, 7}, new int[] {17, 7}, new int[] {17, 8}, new int[] {17, 9},
            new int[] {17, 10}, new int[] {17, 11}, new int[] {18, 11}, new int[] {19, 11}, new int[] {19, 10},
            new int[] {19, 9}, new int[] {19, 8}, new int[] {19, 7}, new int[] {20, 7}, new int[] {21, 7},
            new int[] {21, 6}, new int[] {21, 5}, new int[] {22, 5}, new int[] {23, 5}, new int[] {23, 4},
            new int[] {23, 3}, new int[] {22, 3}, new int[] {21, 3}, new int[] {21, 2}, new int[] {21, 1},
            new int[] {22, 1}, new int[] {23, 1}, new int[] {24, 1}, new int[] {25, 1}, new int[] {26, 1},
            new int[] {27, 1}, new int[] {27, 2}, new int[] {27, 3}, new int[] {26, 3}, new int[] {25, 3},
            new int[] {25, 4}, new int[] {25, 5}, new int[] {25, 6}, new int[] {25, 7}, new int[] {26, 7},
            new int[] {27, 7}, new int[] {28, 7}, new int[] {29, 7}, new int[] {29, 6}, new int[] {29, 5},
            new int[] {29, 4}, new int[] {29, 3}, new int[] {30, 3}, new int[] {31, 3}, new int[] {31, 4},
            new int[] {31, 5}, new int[] {31, 6}, new int[] {31, 7}, new int[] {31, 8}, new int[] {31, 9},
            new int[] {30, 9}, new int[] {29, 9}, new int[] {28, 9}, new int[] {27, 9}, new int[] {26, 9},
            new int[] {25, 9}, new int[] {24, 9}, new int[] {23, 9}, new int[] {23, 10}, new int[] {23, 11},
            new int[] {24, 11}, new int[] {25, 11}, new int[] {26, 11}, new int[] {27, 11}, new int[] {27, 12},
            new int[] {27, 13}, new int[] {27, 14}, new int[] {27, 15}, new int[] {27, 16}, new int[] {27, 17},
            new int[] {26, 17}, new int[] {25, 17}, new int[] {25, 16}, new int[] {25, 15}, new int[] {24, 15},
            new int[] {23, 15}, new int[] {22, 15}, new int[] {21, 15}, new int[] {20, 15}, new int[] {19, 15},
            new int[] {19, 16}, new int[] {19, 17}, new int[] {19, 18}, new int[] {19, 19}, new int[] {18, 19},
            new int[] {17, 19}, new int[] {17, 18}, new int[] {17, 17}, new int[] {16, 17}, new int[] {15, 17},
            new int[] {14, 17}, new int[] {13, 17}, new int[] {12, 17}, new int[] {11, 17}, new int[] {10, 17},
            new int[] {9, 17}, new int[] {9, 18}, new int[] {9, 19}, new int[] {9, 20}, new int[] {9, 21},
            new int[] {10, 21}, new int[] {11, 21}, new int[] {11, 22}, new int[] {11, 23}, new int[] {11, 24},
            new int[] {11, 25}, new int[] {11, 26}, new int[] {11, 27}, new int[] {12, 27}, new int[] {13, 27},
            new int[] {14, 27}, new int[] {15, 27}, new int[] {15, 28}, new int[] {15, 29}, new int[] {15, 30},
            new int[] {15, 31}, new int[] {16, 31}, new int[] {17, 31}, new int[] {18, 31}, new int[] {19, 31},
            new int[] {19, 30}, new int[] {19, 29}, new int[] {18, 29}, new int[] {17, 29}, new int[] {17, 28},
            new int[] {17, 27}, new int[] {18, 27}, new int[] {19, 27}, new int[] {20, 27}, new int[] {21, 27},
            new int[] {21, 28}, new int[] {21, 29}, new int[] {21, 30}, new int[] {21, 31}, new int[] {22, 31},
            new int[] {23, 31}, new int[] {24, 31}, new int[] {25, 31}, new int[] {26, 31}, new int[] {27, 31},
            new int[] {28, 31}, new int[] {29, 31}, new int[] {30, 31}, new int[] {31, 31}
        );

        List<int[]> path = BFSSolver.getPath(matrix, 1, 1, 31, 31, null);

        assertThat(path.size()).isEqualTo(correctPath.size());

        for (int i = 0; i < path.size(); ++i) {
            assertThat(path.get(i)).isEqualTo(correctPath.get(i));
        }
    }

    @Disabled
    @Test
    void test_find_path_bfs() throws InterruptedException {
        int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Maze maze = new Maze(60, 30, OLDOS_BROADER_GENERATE, true);
        List<int[]> path = maze.getMinPath(1, 1, 31, 61, BFS);
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
        assertThat(path.get(path.size() - 1)[0]).isEqualTo(31);
        assertThat(path.get(path.size() - 1)[1]).isEqualTo(61);
    }


    @Test
    void test_correct_start_and_end_of_path() throws InterruptedException {
        Maze maze = new Maze(78, 22, WILSON_GENERATE, false);
        List<int[]> path = maze.getMinPath(1, 1, 23, 79, BFS);

        assertThat(path.get(0)[0]).isEqualTo(1);
        assertThat(path.get(0)[1]).isEqualTo(1);
        assertThat(path.get(path.size() - 1)[0]).isEqualTo(23);
        assertThat(path.get(path.size() - 1)[1]).isEqualTo(79);

    }
    @ParameterizedTest
    @MethodSource("getInvalidCoordinatesForDFS")
    void throw_if_coordinates_is_not_correct(int x1, int y1, int x2, int y2) {
        var except = assertThrows(
            IllegalArgumentException.class,
            () -> new Maze(30, 30, WILSON_GENERATE, false).getMinPath(x1, y1, x2, y2, DFS)
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
