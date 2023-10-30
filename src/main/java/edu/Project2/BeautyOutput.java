package edu.Project2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static edu.Project2.Maze.PATH;
import static edu.Project2.WilsonGenerate.BORDER;
import static edu.Project2.WilsonGenerate.WALL;

@SuppressWarnings({"MagicNumber", "ImportOrder"})
public class BeautyOutput extends JFrame {
    public JPanel panel;

    public BeautyOutput(char[][] matrix) {
        setSize(matrix[0].length * 15, matrix.length * 15);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int squareSize = 10;
                int x = 20;
                int y = 10;
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        int randomInt = new Random().nextInt();
                        if (matrix[i][j] == BORDER || matrix[i][j] == WALL) {
                            g.setColor(Color.BLACK);
                        } else if (matrix[i][j] == PATH) {
                            g.setColor(Color.RED);
                        } else if (matrix[i][j] == 'M') {
                            g.setColor(Color.BLUE);
                        } else {
                            g.setColor(Color.WHITE);
                        }
                        g.fillRect(x + j * squareSize, y + i * squareSize, squareSize, squareSize);
                        g.setColor(Color.BLACK);
                        g.drawRect(x + j * squareSize, y + i * squareSize, squareSize, squareSize);
                    }
                }
            }
        };

        add(panel);

    }

}
