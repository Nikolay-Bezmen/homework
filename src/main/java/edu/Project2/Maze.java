package edu.Project2;

import java.util.List;
import static edu.Project2.DFSSolver.DFS;
import static edu.Project2.OldosBroaderGenerate.OLDOS_BROADER_GENERATE;

@SuppressWarnings({"MagicNumber", "ImportOrder"})
public class Maze {
    public final static char BORDER = (char) 497;
    public final static char SPACE = ' ';
    public final static char PATH = '*';
//    private final static Logger LOGGER = LogManager.getLogger();
    private final char[][] matrix;
    BeautyOutput bo;
    private final boolean paint;

    public Maze(int height, int width, String typeOfGenerate, boolean paint) throws InterruptedException {
        this.paint = paint;
        if (typeOfGenerate.equals(OLDOS_BROADER_GENERATE)) {
            matrix = (new OldosBroaderGenerate(height, width).generate());
        } else {
            matrix = (new WilsonGenerate(height, width).generate());
        }
        bo = new BeautyOutput(matrix);
        bo.setVisible(paint);
    }

    public List<int[]> getMinPath(int x1, int y1, int x2, int y2, String typeOfSearch) throws InterruptedException {
        List<int[]> path;
        if (typeOfSearch.equals(DFS)) {
            path = DFSSolver.getPath(matrix, x1, y1, x2, y2, paint ? bo : null);
        } else {
            path = BFSSolver.getPath(matrix, x1, y1, x2, y2, paint ? bo : null);
        }
        //for dfs : x1, y1, x2, y2
        //for bfs : y1, x1, y2, x2

        return path;
    }

    public void printMaze() throws InterruptedException {
        bo.setVisible(true);
        bo.repaint();
        Thread.sleep(5000);
        bo.setVisible(false);
    }

    public void printMaze(long delay) throws InterruptedException {
        bo.setVisible(true);
        bo.repaint();
        Thread.sleep(delay);
        bo.setVisible(false);
    }

}
