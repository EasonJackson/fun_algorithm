/**
 * Created by easonjackson on 1/31/18.
 */
public class App {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);
        root.right.right.left.left = new TreeNode(8);
        root.right.right.left.left.left = new TreeNode(9);
        root.right.right.left.left.left.left = new TreeNode(10);
        root.right.right.left.left.left.left.left = new TreeNode(11);
        root.right.right.left.left.left.left.right = new TreeNode(12);


        TopViewBT solution = new TopViewBT();
        solution.topViewBT(root);

    }
}
