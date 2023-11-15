package edu.Project2;

import java.util.ArrayList;
import java.util.List;
import static edu.Project2.Maze.PATH;
import static edu.Project2.Maze.SPACE;

@SuppressWarnings({"HideUtilityClassConstructor", "ReturnCount", "MagicNumber"})
public class DFSSolver {
    public final static String DFS = "dfs";
    public final static String COORDINATE_INCORRECT = "неверные координаты";
    private static final int[][] PATH_DIRESTIONS = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static char[][] matrix;
    private static boolean[][] seen;
    private static boolean find = false;
    private static BeautyOutput beautyOutput;

    public static List<int[]> getPath(char[][] matrixFromMaze, int x1, int y1, int x2, int y2, BeautyOutput bo)
        throws InterruptedException {
        beautyOutput = bo;
        matrix = matrixFromMaze;
        int height = matrix.length;
        int width = matrix[0].length;
        seen = new boolean[height][width];

        if (x1 < 1 || x2 < 1 || x1 >= width - 1 || x2 >= width - 1
            || y1 < 1 || y2 < 1 || y1 >= height - 1 || y2 >= height - 1) {
            throw new IllegalArgumentException(COORDINATE_INCORRECT);
        }
        dfs(x1, y1, x2, y2);

        List<int[]> path = new ArrayList<>();
        path.add(new int[] {x1, y1});

        createPathInMatrix(path, x1, y1, x2, y2);

        return path;
    }

    private static void dfs(int x, int y, int findX, int findY) throws InterruptedException {
        if (y == findX && x == findY) {
            find = true;
            matrix[x][y] = PATH;
            return;
        }

        for (int[] direction : PATH_DIRESTIONS) {
            int dx = x + direction[0];
            int dy = y + direction[1];

            if (isValid(dx, dy) && matrix[dx][dy] == SPACE) {
                matrix[dx][dy] = 'M';
                paint(20, beautyOutput);
                dfs(dx, dy, findX, findY);
                if (find) {
                    matrix[x][y] = PATH;
                    paint(20, beautyOutput);
                    return;
                }
            }
        }
    }

    private static void createPathInMatrix(List<int[]> path, int x, int y, int endX, int endY) {
        int currX = x;
        int currY = y;
        while (currX != endY || currY != endX) {
            for (int[] direction : PATH_DIRESTIONS) {
                int dx = currX + direction[0];
                int dy = currY + direction[1];
                if (isValid(dx, dy) && matrix[dx][dy] == PATH && !seen[dx][dy]) {
                    seen[dx][dy] = true;
                    currX = dx;
                    currY = dy;
                    path.add(new int[] {currX, currY});
                    break;
                }
            }
        }
    }

    private static void paint(long delay, BeautyOutput bo) throws InterruptedException {
        if (bo != null) {
            bo.repaint();
            Thread.sleep(delay);
        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 1 && y >= 1 && y < matrix[0].length - 1 && x < matrix.length - 1;
    }

}
