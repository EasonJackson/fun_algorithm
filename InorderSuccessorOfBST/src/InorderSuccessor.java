/**
 * Created by easonjackson on 2/8/18.
 *
 * Inorder successor of a node in BST without referencing to parents node
 */
public class InorderSuccessor {

    public BSTreeNode findSuccessor(BSTreeNode root, BSTreeNode target) {
        if (root == null) {
            return null;
        }

        if (target.right != null) {
            return findMin(target.right);
        }

        BSTreeNode successor = null;
        BSTreeNode scanner = root;
        while (scanner != null && scanner != target) {
            if (scanner.val > target.val) {
                successor = scanner;
                scanner = scanner.left;
            } else {
                scanner = scanner.right;
            }
        }

        return successor;
    }

    private BSTreeNode findMin(BSTreeNode node) {
        while(node.left != null) {
            node = node.left;
        }

        return node;
    }
}
