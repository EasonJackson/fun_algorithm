/**
 * Created by easonjackson on 2/24/18.
 */
public class App {

    public static void main(String[] args) {

        //      10
        //      /\
        //     1  5
        //    /\   \
        //   2 4   19
        //  /  \   /
        // 1   6  1

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(19);
        root.left.left.left = new TreeNode(1);
        root.left.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(1);

        NonLeafSum sum = new NonLeafSum();
        System.out.print(sum.nonLeafSum(root));
    }
}
