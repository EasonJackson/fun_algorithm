import java.util.Stack;

/**
 * Created by easonjackson on 1/31/18.
 */
public class TernaryExpToBT {

    public TreeNode TernaryExpToBT(String express) {
        if (express == null || express.length() == 0) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = new TreeNode(express.charAt(0));
        TreeNode root = pre;
        for (int i = 1; i < express.length(); i++) {
            if (express.charAt(i) == '?') {
                stack.push(pre);
            } else if (express.charAt(i) == ':') {
                //stack.pop();
                while (!stack.isEmpty() && stack.peek().left != null && stack.peek().right != null) {
                    stack.pop();
                }
            } else {
                pre = new TreeNode(express.charAt(i));
                if (!stack.isEmpty()) {
                    if (stack.peek().left == null) {
                        stack.peek().left = pre;
                    } else {
                        stack.peek().right = pre;
                    }
                }
            }
        }

        return root;
    }
}
