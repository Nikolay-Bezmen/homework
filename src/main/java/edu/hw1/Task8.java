package edu.hw1;

import java.io.IOException;

public class Task8 {
    public final String invalidBoardPassed = "передана неверная доска";

    public boolean knightBoardCapture(int[][] field) throws IOException {
        final int one = 1;
        final int two = 2;
        int n = field.length;
        int[][] directions = new int[][] {{two, one}, {two, -one}, {-two, one}, {-two, -one},
            {one, two}, {one, -two}, {-one, -two}, {-one, two}};
        for (int i = 0; i < n; ++i) {
            if (field[i] == null || field[i].length != n) {
                throw new IOException(invalidBoardPassed);
            }
            for (int j = 0; j < n; ++j) {
                if (field[i][j] == 1) {
                    for (int[] direction : directions) {
                        int dx = i + direction[0];
                        int dy = j + direction[1];
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
