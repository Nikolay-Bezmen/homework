package edu.Project2;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static edu.Project2.DFSSolver.DFS;
import static edu.Project2.OldosBroaderGenerate.OLDOS_BROADER_GENERATE;

@SuppressWarnings({"MagicNumber", "ImportOrder"})
public class Maze {
    public final static char BORDER = (char) 497;
    public final static char SPACE = ' ';
    public final static char PATH = '*';
    private final static Logger LOGGER = LogManager.getLogger();
    private char[][] matrix;
    BeautyOutput bo;

    public Maze(int height, int width, String typeOfGenerate) throws InterruptedException {
        if (typeOfGenerate.equals(OLDOS_BROADER_GENERATE)) {
            matrix = (new OldosBroaderGenerate(height, width).generate());
        } else {
            matrix = (new WilsonGenerate(height, width).generate());
        }
        bo = new BeautyOutput(matrix);
    }

    public List<int[]> getMinPath(int x1, int y1, int x2, int y2, String typeOfSearch) throws InterruptedException {
        List<int[]> path;
        if (typeOfSearch.equals(DFS)) {
            path = DFSSolver.getPath(matrix, x1, y1, x2, y2);
        } else {
            path = BFSSolver.getPath(matrix, x1, y1, x2, y2, null);
        }
        //for dfs : x1, y1, x2, y2
        //for bfs : y1, x1, y2, x2

        return path;
    }

    public void printMaze() {
        bo.setVisible(true);
        bo.repaint();
        for (char[] chars : matrix) {
            StringBuilder sb = new StringBuilder();
            for (char ch : chars) {
                sb.append(ch).append(" ");
            }
            LOGGER.warn(sb);
        }
    }

}
