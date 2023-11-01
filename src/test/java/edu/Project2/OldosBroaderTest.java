package edu.Project2;

import org.junit.jupiter.api.Test;
import static edu.Project2.OldosBroaderGenerate.OLDOS_BROADER_GENERATE;

public class OldosBroaderTest {
    @Test
    void test_oldos_broader_beauty_output() throws InterruptedException {
        Maze maze = new Maze(60, 30, OLDOS_BROADER_GENERATE, true);
        maze.printMaze();
    }
}
