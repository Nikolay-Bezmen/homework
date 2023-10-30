package edu.Project2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static edu.Project2.DFSSolver.COORDINATE_INCORRECT;
import static edu.Project2.Maze.BORDER;
import static edu.Project2.Maze.PATH;
import static edu.Project2.Maze.SPACE;

@SuppressWarnings({"MagicNumber", "HideUtilityClassConstructor", "CyclomaticComplexity", "ImportOrder"})

public class BFSSolver {
    private final static Logger LOGGER = LogManager.getLogger();
    public final static String BFS = "bfs";
    private static final int[][] PATH_DIRECTIONS = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static int height;
    private static int width;


    public static List<int[]> getPath(char[][] matrix, int x1, int y1, int x2, int y2, BeautyOutput bo)
        throws InterruptedException {
        height = matrix.length;
        width = matrix[0].length;

        if (x1 < 1 || x2 < 1 || x1 >= width - 1 || x2 >= width - 1
            || y1 < 1 || y2 < 1 || y1 >= height - 1 || y2 >= height - 1) {
            throw new IllegalArgumentException(COORDINATE_INCORRECT);
        }
        if (matrix[y1][x1] == BORDER || matrix[y2][x2] == BORDER) {
            LOGGER.warn("Это не свободная клетка");
        }
        Queue<List<int[]>> queue = new LinkedList<>();
        List<int[]> st = new ArrayList<>();
        st.add(new int[] {x1, y1});
        queue.add(st);
        List<int[]> path = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<int[]> currPath = queue.poll();
            int[] currDot = currPath.get(currPath.size() - 1);
            int x = currDot[0];
            int y = currDot[1];
            boolean flag = false;
            for (int[] pathDirection : PATH_DIRECTIONS) {
                int dx = x + pathDirection[0];
                int dy = y + pathDirection[1];

                if (isValid(dx, dy) && matrix[dy][dx] == SPACE) {
                    currPath.add(new int[] {dx, dy});
                    matrix[dy][dx] = 'M';
                    if (dx == x2 && dy == y2) {
                        flag = true;
                        path = currPath;
                        break;
                    }
                    queue.add(new ArrayList<>(currPath));
                    if (bo != null) {
                        bo.repaint();
                        Thread.sleep(5);
                    }
                    currPath.remove(currPath.size() - 1);
                }
            }
            if (flag) {
                break;
            }
        }

        for (int i = 0; i < path.size(); ++i) {
            matrix[path.get(i)[1]][path.get(i)[0]] = PATH;
            if (bo != null) {
                bo.repaint();
                Thread.sleep(20);
            }
        }

        return path;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && y < height - 1 && x < width - 1;
    }

}
