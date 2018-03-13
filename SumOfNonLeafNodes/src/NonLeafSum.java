/**
 * Created by easonjackson on 2/24/18.
 */
public class NonLeafSum {

    public int nonLeafSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }

        int leftSum = 0, rightSum = 0;
        if (root.left != null) {
            leftSum = helper(root.left);
        }

        if (root.right != null) {
            rightSum = helper(root.right);
        }

        return root.val + leftSum + rightSum;
    }
}
