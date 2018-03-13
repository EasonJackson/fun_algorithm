/**
 * Created by easonjackson on 2/22/18.
 */
public class App {

    public static void main(String[] args) {
        //       10
        //       /\
        //      6 12
        //      /\  \
        //     3 8   15
        //    /\ /\
        //   1 4 7 9
        BSTreeNode root = new BSTreeNode(10);
        root.left = new BSTreeNode(6);
        root.right = new BSTreeNode(12);
        root.left.left = new BSTreeNode(3);
        root.left.right = new BSTreeNode(8);
        root.right.right = new BSTreeNode(15);
        root.left.left.left = new BSTreeNode(1);
        root.left.left.right = new BSTreeNode(4);
        root.left.right.left = new BSTreeNode(7);
        root.left.right.right = new BSTreeNode(9);

        BSTreeNode test1 = root.right.right; // 15
        BSTreeNode test2 = root.left.right; // 8
        BSTreeNode test3 = root.left.left.right; // 4

        InorderSuccessor successor = new InorderSuccessor();
        System.out.println(successor.findSuccessor(root, test1) == null);
        System.out.println(successor.findSuccessor(root, test2).val);
        System.out.println(successor.findSuccessor(root, test3).val);
    }
}
