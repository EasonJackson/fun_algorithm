/**
 * Created by easonjackson on 2/22/18.
 */
public class App {

    public static void main(String[] args) {
        // F F F F F
        // T T T T F
        // F F T F F
        // F F F F F
        // F F F F F
        boolean[][] maze = new boolean[5][5];
        maze[1][0] = true;
        maze[1][1] = true;
        maze[1][2] = true;
        maze[1][3] = true;
        maze[2][2] = true;

        int[] start = {1, 0};

        MazePathFiller filler = new MazePathFiller();

        filler.allPositionInMaze(maze, start);
    }
}
