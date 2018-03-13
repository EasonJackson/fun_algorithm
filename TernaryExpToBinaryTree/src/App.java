import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by easonjackson on 1/31/18.
 */
public class App {

    public static void main(String[] args) {
        String exp = "a?b:c?d?e?f?g?h:i:j:k:e?f:g";

        TernaryExpToBT solution = new TernaryExpToBT();
        TreeNode node = solution.TernaryExpToBT(exp);

        printTree(node);
    }

    private static void printTree(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode n = queue.poll();
                System.out.print(n.c + " ");
                if (n.c == '#') {
                    continue;
                }
                if (n.left != null) {
                    queue.offer(n.left);
                } else {
                    queue.offer(new TreeNode('#'));
                }
                if (n.right != null) {
                    queue.offer(n.right);
                } else {
                    queue.offer(new TreeNode('#'));
                }
            }
            System.out.println("");
        }
    }
}
