import java.util.*;

/**
 * Created by easonjackson on 2/3/18.
 */
public class MazePathFinder {

    class Node {
        int[] position;
        Node ancestor;
        int distance;

        Node (int[] position, int distance) {
            this.position = position;
            this.distance = distance;
            this.ancestor = null;
        }
    }

    public void shortestPath(char[][] input) {
        int[] startPos = findPos(input, '2');
        int[] targetPos = findPos(input, '3');

        bfs(startPos, targetPos, input);
    }

    private int[] findPos(char[][] maze, char num) {
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                if (maze[row][col] == num) {
                    return new int[]{row, col};
                }
            }
        }

        return new int[]{-1, -1};
    }

    private void bfs(int[] startPos, int[] targetPos, char[][] maze) {
        // Record for visited positions
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startPos, 0));
        visited[startPos[0]][startPos[1]] = true;

        Node target = new Node(targetPos, Integer.MAX_VALUE);

        // Record for key collected at corresponding node
        Map<Character, Node> keys = new HashMap<>();

        while (!queue.isEmpty()) {

            Node curr = queue.poll();
            int x = curr.position[0], y = curr.position[1];

            // Target
            if (x == targetPos[0] && y == targetPos[1]) {
                target = curr;
                break;
            }

            // Door
            if (maze[x][y] >= 'A' && maze[x][y] <= 'Z') {
                if (keys.containsKey(Character.toLowerCase(maze[x][y]))) {
                    curr.distance = findMinDist(keys.get(Character.toLowerCase(maze[x][y])), curr);
                    queue.offer(curr);
                } else {
                    // No key, throw curr node back to queue
                    queue.offer(curr);
                    continue;
                }
            }

            // UP
            if (x - 1 >= 0 && maze[x - 1][y] != '0' && !visited[x - 1][y]) {
                Node up = new Node(new int[]{x - 1, y}, curr.distance + 1);
                up.ancestor = curr;
                if (maze[x - 1][y] >= 'a' && maze[x - 1][y] <= 'z') {
                    keys.put(maze[x - 1][y], up);
                }
                queue.offer(up);
                visited[x - 1][y] = true;
            }

            // DOWN
            if (x + 1 < maze.length && maze[x + 1][y] != '0' && !visited[x + 1][y]) {
                Node down = new Node(new int[]{x + 1, y}, curr.distance + 1);
                down.ancestor = curr;
                if (maze[x + 1][y] >= 'a' && maze[x + 1][y] <= 'z') {
                    keys.put(maze[x + 1][y], down);
                }
                queue.offer(down);
                visited[x + 1][y] = true;
            }

            // LEFT
            if (y - 1 >= 0 && maze[x][y - 1] != '0' && !visited[x][y - 1]) {
                Node left = new Node(new int[]{x, y - 1}, curr.distance + 1);
                left.ancestor = curr;
                if (maze[x][y - 1] >= 'a' && maze[x][y - 1] <= 'z') {
                    keys.put(maze[x][y - 1], left);
                }
                queue.offer(left);
                visited[x][y - 1] = true;
            }

            // RIGHT
            if (y + 1 < maze[0].length && maze[x][y + 1] != '0' && !visited[x][y + 1]) {
                Node right = new Node(new int[]{x, y + 1}, curr.distance + 1);
                right.ancestor = curr;
                if (maze[x][y + 1] >= 'a' && maze[x][y + 1] <= 'z') {
                    keys.put(maze[x][y + 1], right);
                }
                queue.offer(right);
                visited[x][y + 1] = true;
            }

        }

        while (target != null) {
            System.out.print("[" + target.position[0] + ", " + target.position[1] + "] <- " );
            target = target.ancestor;
        }
    }

    // Retrieve dist of two nodes from singly linked list
    // Find lowest ancestor of two nodes,
    private int findMinDist(Node key, Node door) {
        int len1 = 0, len2 = 0;

        Node scanner = key;
        while (scanner.ancestor != null) {
            len1 ++;
            scanner = scanner.ancestor;
        }

        scanner = door;
        while (scanner.ancestor != null) {
            len2 ++;
            scanner = scanner.ancestor;
        }

        Node dummy1 = key, dummy2 = door;
        if (len1 >= len2) {
            for (int i = 1; i <= len1 - len2; i++) {
                dummy1 = dummy1.ancestor;
            }

            int commomLen = 0;
            while (dummy1 != dummy2) {
                commomLen++;
                dummy1 = dummy1.ancestor;
                dummy2 = dummy2.ancestor;
            }

            return key.distance + (len1 - len2) + 2 * commomLen;
        } else {
            for (int i = 1; i <= len2 - len1; i++) {
                dummy2 = dummy2.ancestor;
            }

            int commomLen = 0;
            while (dummy1 != dummy2) {
                commomLen++;
                dummy1 = dummy1.ancestor;
                dummy2 = dummy2.ancestor;
            }

            return key.distance + (len2 - len1) + 2 * commomLen;
        }
    }
}
