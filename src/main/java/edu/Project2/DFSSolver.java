package edu.Project2;

import java.util.ArrayList;
import java.util.List;
import static edu.Project2.Maze.PATH;
import static edu.Project2.Maze.SPACE;

@SuppressWarnings({"HideUtilityClassConstructor", "ReturnCount"})
public class DFSSolver {
    public final static String DFS = "dfs";
    public final static String COORDINATE_INCORRECT = "неверные координаты";
    private static final int[][] PATH_DIRESTIONS = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static int height;
    private static int width;
    private static char[][] matrix;
    private static int findX;
    private static int findY;
    private static boolean find = false;
    private static boolean[][] seen;
    private static BeautyOutput bo;

    public static List<int[]> getPath(char[][] matrixFromMaze, int x1, int y1, int x2, int y2, BeautyOutput BO)
        throws InterruptedException {
        bo = BO;
        matrix = matrixFromMaze;
        height = matrix.length;
        width = matrix[0].length;
        seen = new boolean[height][width];
        findX = x2;
        findY = y2;
        if (x1 < 1 || x2 < 1 || x1 >= width - 1 || x2 >= width - 1
            || y1 < 1 || y2 < 1 || y1 >= height - 1 || y2 >= height - 1) {
            throw new IllegalArgumentException(COORDINATE_INCORRECT);
        }
        dfs(x1, y1);

        List<int[]> path = new ArrayList<>();
        int currX = x1;
        int currY = y1;
        path.add(new int[] {currX, currY});

        while (currX != y2 || currY != x2) {
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

        return path;
    }

    private static void dfs(int x, int y) throws InterruptedException {
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
                if (bo != null) {
                    bo.repaint();
                    Thread.sleep(20);
                }
                dfs(dx, dy);
                if (find) {
                    matrix[x][y] = PATH;
                    if (bo != null) {
                        bo.repaint();
                        Thread.sleep(20);
                    }
                    return;
                }
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 1 && y >= 1 && y < width - 1 && x < height - 1;
    }

}
