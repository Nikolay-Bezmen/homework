package edu.Project2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

@SuppressWarnings({"MagicNumber", "MemberName"})
public class WilsonGenerate implements Generator {
    public final static String WILSON_GENERATE = "wilson";
    private final boolean[][] seen;
    private final char[][] matrix;
    private final int[][] directions = new int[][] {{2, 0, 1, 0}, {0, 2, 0, 1}, {-2, 0, -1, 0}, {0, -2, 0, -1}};
    public final static char BORDER = (char) 497;
    public final static char WALL = 'N';
    public final static char SPACE = ' ';
    private final int HEIGHT;
    private final int WIDTH;
    private final Random random = new Random();

    WilsonGenerate(int height, int width) {
        HEIGHT = height + 2 + (height % 2 == 0 ? 1 : 0);
        WIDTH = width + 2 + (width % 2 == 0 ? 1 : 0);

        seen = new boolean[Math.abs(HEIGHT - 2)][Math.abs(WIDTH - 2)];
        matrix = new char[HEIGHT][WIDTH];
    }

    @Override
    public char[][] generate() {
        for (int i = 1; i < HEIGHT - 1; ++i) {
            for (int j = 1; j < WIDTH - 1; ++j) {
                matrix[i][j] = WALL;
            }
        }
        paintBoarders();
        generateMaze();
        return matrix;
    }

    private void generateMaze() {
        int startX = getRandomValidX();
        int startY = getRandomValidY();

        seen[startX][startY] = true;
        matrix[startX + 1][startY + 1] = SPACE;

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {startX, startY});

        while (!stack.isEmpty()) {
            int x = stack.peek()[0];
            int y = stack.peek()[1];

            List<int[]> nextCells = new ArrayList<>();

            for (int[] direction : directions) {
                int dx = x + direction[0];
                int dy = y + direction[1];

                if (isValid(dx, dy) && !seen[dx][dy]) {
                    nextCells.add(new int[] {dx, dy, x + direction[2], y + direction[3]});
                }
            }

            if (!nextCells.isEmpty()) {
                int[] nextCell = nextCells.get(random.nextInt(nextCells.size()));

                matrix[nextCell[0] + 1][nextCell[1] + 1] = SPACE;
                matrix[nextCell[2] + 1][nextCell[3] + 1] = SPACE;

                seen[nextCell[0]][nextCell[1]] = true;

                stack.push(new int[] {nextCell[0], nextCell[1]});
            } else {
                stack.pop();
            }
        }
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && y < WIDTH - 2 && x < HEIGHT - 2;
    }

    private int getRandomValidX() {
        int x = random.nextInt(HEIGHT - 2);
        while (x % 2 == 1) {
            x = random.nextInt(HEIGHT - 2);
        }

        return x;
    }

    private int getRandomValidY() {
        int y = random.nextInt(WIDTH - 2);
        while (y % 2 == 1) {
            y = random.nextInt(WIDTH - 2);
        }

        return y;
    }

    private void paintBoarders() {
        for (int i = 0; i < HEIGHT; ++i) {
            matrix[i][0] = BORDER;
            matrix[i][WIDTH - 1] = BORDER;
        }

        for (int i = 1; i < WIDTH; ++i) {
            matrix[0][i] = BORDER;
            matrix[HEIGHT - 1][i] = BORDER;
        }
    }
}
