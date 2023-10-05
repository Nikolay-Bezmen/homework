package edu.hw1;

public class Task8 {
    public static boolean knightBoardCapture(int[][] field) {
        int n = field.length;
        int[][] directions = new int[][]{{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, -2}, {-1, 2}};
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (field[i][j] == 1) {
                    for (int[] direction : directions) {
                        int dx = i + direction[0], dy = j + direction[1];
                        if (isValid(dx, dy, n) && field[dx][dy] == 1) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static boolean isValid(int x, int y, int n) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}
