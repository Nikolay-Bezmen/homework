package edu.Project2;

import java.util.Random;

@SuppressWarnings({"MagicNumber", "MemberName"})
public class OldosBroaderGenerate implements Generator {
    public final static String OLDOS_BROADER_GENERATE = "oldos broader";
    private final boolean[][] seen;
    private final char[][] matrix;
    private final int[][] countSeen;
    private final int[][] directions = new int[][] {{2, 0, 1, 0}, {0, 2, 0, 1}, {-2, 0, -1, 0}, {0, -2, 0, -1}};
    public final static char BORDER = (char) 497;
    public final static char WALL = 'N';
    public final static char SPACE = ' ';
    private final int HEIGHT;
    private final int WIDTH;

    OldosBroaderGenerate(int height, int width) {
        HEIGHT = height + 2 + (height % 2 == 0 ? 1 : 0);
        WIDTH = width + 2 + (width % 2 == 0 ? 1 : 0);

        seen = new boolean[Math.abs(HEIGHT - 2)][Math.abs(WIDTH - 2)];
        matrix = new char[HEIGHT][WIDTH];
        countSeen = new int[Math.abs(HEIGHT - 2)][Math.abs(WIDTH - 2)];
    }

    @Override
    public char[][] generate() {
        for (int i = 1; i < HEIGHT - 1; ++i) {
            for (int j = 1; j < WIDTH - 1; ++j) {
                matrix[i][j] = WALL;
            }
        }
        paintBoarders();
        seen[0][0] = true;
        matrix[1][1] = SPACE;
        generateMaze(0, 0);

        return matrix;
    }

    private void generateMaze(int x, int y) {
        boolean[] randomSeen = new boolean[4];
        int i = 0;
        while (i < 4) {
            ++i;
            int randIndex = getRandomDirection(randomSeen);
            randomSeen[randIndex] = true;
            int[] direction = directions[randIndex];
            int dx = x + direction[1];
            int dy = y + direction[0];
            int px = x + direction[3];
            int py = y + direction[2];

            if (isValid(dx, dy) && countSeen[dy][dx] < 2) {
                ++countSeen[dy][dx];

                if (!seen[dy][dx]) {
                    seen[dy][dx] = true;
                    seen[py][px] = true;
                    matrix[py + 1][px + 1] = SPACE;
                }

                matrix[dy + 1][dx + 1] = SPACE;
                generateMaze(dx, dy);
            }
        }
    }

    private int getRandomDirection(boolean[] randomSeen) {
        while (true) {
            int rand = Math.abs(Math.abs(new Random().nextInt()) % 4);
            if (randomSeen[rand]) {
                continue;
            }
            return rand;
        }
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && y < HEIGHT - 2 && x < WIDTH - 2;
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
