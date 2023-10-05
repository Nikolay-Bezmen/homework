package edu.hw1;

import java.io.IOException;

public class Task8 {
    public boolean knightBoardCapture(int[][] field) throws IOException {
        int n = field.length;
        int[][] directions = new int[][] {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, -2}, {-1, 2}};
        for (int i = 0; i < n; ++i) {
            if (field[i] == null || field[i].length != n) {
                throw new IOException("передана неверная доска");
            }
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

    public boolean isValid(int x, int y, int n) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}
