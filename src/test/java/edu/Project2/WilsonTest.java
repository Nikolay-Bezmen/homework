package edu.Project2;

import org.junit.jupiter.api.Test;
import static edu.Project2.WilsonGenerate.WILSON_GENERATE;

public class WilsonTest {
    @Test
    void test_oldos_broader_beauty_output() throws InterruptedException {
        Maze maze = new Maze(60, 30, WILSON_GENERATE, true);
        maze.printMaze();
    }
}
