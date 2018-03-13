import java.util.Stack;

/**
 * Created by easonjackson on 2/22/18.
 *
 * A Robot is placed at start position in a 2D maze
 * The Robot can move in 4 directions: up, down, left, and right, if the block has a value of true
 * The method will return a trace of the Robot covering every position that can be reached
 */
public class MazePathFiller {

    public void allPositionInMaze(boolean[][] maze, int[] start) {
        Robot rob = new Robot(start[0], start[1]);
        rob.printLocation();

        boolean[][] visited = new boolean[maze.length][maze[0].length];

        Stack<int[]> stack = new Stack<>();
        stack.push(start);
        visited[start[0]][start[1]] = true;

        while (!stack.isEmpty()) {
            int[] curr = stack.peek();
            int[] left = {curr[0], curr[1] - 1};
            int[] right = {curr[0], curr[1] + 1};
            int[] up = {curr[0] - 1, curr[1]};
            int[] down = {curr[0] + 1, curr[1]};
            if (left[0] >= 0 && left[0] < maze.length && left[1] >= 0 && left[1] < maze[0].length
                    && !visited[left[0]][left[1]] && maze[left[0]][left[1]]) {
                visited[left[0]][left[1]] = true;
                stack.push(left);
                rob.moveLeft();
                rob.printLocation();
            } else if (right[0] >= 0 && right[0] < maze.length && right[1] >= 0 && right[1] < maze[0].length
                    && !visited[right[0]][right[1]] && maze[right[0]][right[1]]) {
                visited[right[0]][right[1]] = true;
                stack.push(right);
                rob.moveRight();
                rob.printLocation();
            } else if (up[0] >= 0 && up[0] < maze.length && up[1] >= 0 && up[1] < maze[0].length
                    && !visited[up[0]][up[1]] && maze[up[0]][up[1]]) {
                visited[up[0]][up[1]] = true;
                stack.push(up);
                rob.moveUp();
                rob.printLocation();
            } else if (down[0] >= 0 && down[0] < maze.length && down[1] >= 0 && down[1] < maze[0].length
                    && !visited[down[0]][down[1]] && maze[down[0]][down[1]]) {
                visited[down[0]][down[1]] = true;
                stack.push(down);
                rob.moveDown();
                rob.printLocation();
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    rob.x = stack.peek()[0];
                    rob.y = stack.peek()[1];
                    rob.printLocation();
                }
            }


        }
    }
}
