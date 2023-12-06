package edu.Project2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import static edu.Project2.Maze.PATH;
import static edu.Project2.Maze.SPACE;

@SuppressWarnings({"MagicNumber", "HideUtilityClassConstructor", "CyclomaticComplexity", "ImportOrder"})

public class BFSSolver {
    public final static String BFS = "bfs";
    private static final int[][] PATH_DIRECTIONS = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static int height;
    private static int width;

    public static List<int[]> getPath(char[][] matrix, int x1, int y1, int x2, int y2, BeautyOutput bo)
        throws InterruptedException {
        height = matrix.length;
        width = matrix[0].length;

        DFSSolver.checkCoordinatesOnCorrect(x1, y1, x2, y2, height, width);

        Queue<List<int[]>> queue = new LinkedList<>();
        List<int[]> st = new ArrayList<>();
        st.add(new int[] {x1, y1});
        queue.add(st);
        List<int[]> path = findPath(matrix, queue, x2, y2, bo);

        assert path != null;
        paintPathMaze(matrix, bo, path);

        return path;
    }

    private static void paintPathMaze(char[][] matrix, BeautyOutput bo, List<int[]> path) throws InterruptedException {
        for (int[] ints : path) {
            matrix[ints[1]][ints[0]] = PATH;
            paint(20, bo);
        }
    }

    private static List<int[]> findPath(char[][] matrix, Queue<List<int[]>> queue, int x2, int y2, BeautyOutput bo)
        throws InterruptedException {
        while (!queue.isEmpty()) {
            List<int[]> currPath = queue.poll();
            int[] currDot = currPath.get(currPath.size() - 1);
            int x = currDot[0];
            int y = currDot[1];
            for (int[] pathDirection : PATH_DIRECTIONS) {
                int dx = x + pathDirection[0];
                int dy = y + pathDirection[1];

                if (isValid(dx, dy) && matrix[dy][dx] == SPACE) {
                    currPath.add(new int[] {dx, dy});
                    matrix[dy][dx] = 'M';
                    if (dx == x2 && dy == y2) {
                        return currPath;
                    }
                    queue.add(new ArrayList<>(currPath));
                    paint(20, bo);
                    currPath.remove(currPath.size() - 1);
                }
            }
        }

        return null;
    }

    private static void paint(long delay, BeautyOutput bo) throws InterruptedException {
        if (bo != null) {
            bo.repaint();
            Thread.sleep(delay);
        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && y < height - 1 && x < width - 1;
    }

}
