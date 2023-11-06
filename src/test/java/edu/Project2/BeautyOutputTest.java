package edu.Project2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static edu.Project2.Maze.BORDER;
import static edu.Project2.Maze.SPACE;
import static edu.Project2.OldosBroaderGenerate.OLDOS_BROADER_GENERATE;
import static edu.Project2.WilsonGenerate.WILSON_GENERATE;

public class BeautyOutputTest {
    @Disabled
    @Test
    void check_beauty_output() throws InterruptedException {
        char[][] matrix = {
            {BORDER, BORDER, BORDER, BORDER},
            {BORDER, SPACE, SPACE, BORDER},
            {BORDER, SPACE, SPACE, BORDER},
            {BORDER,BORDER,BORDER,BORDER}
        };

        BeautyOutput bo = new BeautyOutput(matrix);
        bo.setVisible(true);
        bo.setSize(100, 100);
        bo.repaint();
        Thread.sleep(1000);
    }

    @Disabled
    @Test
    void check_beauty_output_of_maze_with_wilson_generate() throws InterruptedException {
        Maze maze = new Maze(30, 30, WILSON_GENERATE, true);
        maze.printMaze();
    }

    @Disabled
    @Test
    void check_beauty_output_of_maze_with_oldos_broader_generate() throws InterruptedException {
        Maze maze = new Maze(30, 30, OLDOS_BROADER_GENERATE, true);
        maze.printMaze();
    }
}
