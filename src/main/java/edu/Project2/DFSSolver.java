package edu.Project2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import static edu.Project2.Maze.PATH;
import static edu.Project2.Maze.SPACE;

@SuppressWarnings({"HideUtilityClassConstructor", "ReturnCount", "MagicNumber"})
public class DFSSolver {
    public final static String DFS = "dfs";
    public final static String COORDINATE_INCORRECT = "неверные координаты";
    private static final int[][] PATH_DIRECTIONS = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static char[][] matrix;
    private static boolean[][] seen;
    private static BeautyOutput beautyOutput;
    private static ForkJoinPool pool = new ForkJoinPool();

    public static List<int[]> getPath(char[][] matrixFromMaze, int x1, int y1, int x2, int y2, BeautyOutput bo) {
        beautyOutput = bo;
        matrix = matrixFromMaze;
        int height = matrix.length;
        int width = matrix[0].length;
        seen = new boolean[height][width];

        checkCoordinatesOnCorrect(x1, y1, x2, y2, height, width);

        DFSRecursiveTask dfsTask = new DFSRecursiveTask(x1, y1, x2, y2);
        boolean find = pool.invoke(dfsTask);

        List<int[]> path = new ArrayList<>();
        path.add(new int[] {x1, y1});

        if (find) {
            createPathInMatrix(path, x1, y1, x2, y2);
        }

        return path;
    }

    static void checkCoordinatesOnCorrect(int x1, int y1, int x2, int y2, int height, int width) {
        if (x1 < 1 || x2 < 1 || x1 >= width - 1 || x2 >= width - 1
            || y1 < 1 || y2 < 1 || y1 >= height - 1 || y2 >= height - 1) {
            throw new IllegalArgumentException(COORDINATE_INCORRECT);
        }
    }

    private static void createPathInMatrix(List<int[]> path, int x, int y, int endX, int endY) {
        int currX = x;
        int currY = y;
        while (currX != endY || currY != endX) {
            for (int[] direction : PATH_DIRECTIONS) {
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

    private static class DFSRecursiveTask extends RecursiveTask<Boolean> {
        int x;
        int y;
        int findX;
        int findY;

        DFSRecursiveTask(int x, int y, int findX, int findY) {
            this.x = x;
            this.y = y;
            this.findX = findX;
            this.findY = findY;
        }

        @Override
        protected Boolean compute() {
            if (y == findX && x == findY) {
                matrix[x][y] = PATH;
                return true;
            }

            for (int[] direction : PATH_DIRECTIONS) {
                int dx = x + direction[0];
                int dy = y + direction[1];

                if (isValid(dx, dy) && matrix[dx][dy] == SPACE) {
                    matrix[dx][dy] = 'M';
                    try {
                        paint(20, beautyOutput);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    DFSRecursiveTask task = new DFSRecursiveTask(dx, dy, findX, findY);
                    task.fork();
                    boolean result = task.join();
                    if (result) {
                        matrix[x][y] = PATH;
                        try {
                            paint(20, beautyOutput);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        return true;
                    }
                }
            }
            return false;
        }
    }
}

