import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by easonjackson on 1/31/18.
 *
 * An algorithm generate a top-down view of BT
 *
 * Example:
 *          1
 *         / \
 *        2   5
 *       /\   /\
 *      3  1 0  9
 *          /
 *         12
 *        /
 *       20
 *      /
 *    14
 *
 * Generates
 * 14,3,2,1,5,9
 *
 *
 * Solved with ArrayDeque and BFS
 */
public class TopViewBT {

    private class Pair {
        int pos;
        TreeNode node;

        Pair (TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }

    public void topViewBT(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<Pair> record = new ArrayDeque<>();
        //record.addFirst(new Pair(root.val, 0));

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                Pair pair = queue.poll();
                if (record.size() == 0) {
                    record.offer(pair);
                } else if (pair.pos < record.peekFirst().pos) {
                    record.offerFirst(pair);
                } else if (pair.pos > record.peekLast().pos) {
                    record.offerLast(pair);
                }

                if (pair.node.left != null) {
                    queue.offer(new Pair(pair.node.left, pair.pos - 1));
                }

                if (pair.node.right != null) {
                    queue.offer(new Pair(pair.node.right, pair.pos + 1));
                }
            }
        }

        while (!record.isEmpty()) {
            System.out.print(record.pollFirst().node.val + "->");
        }
    }
}
