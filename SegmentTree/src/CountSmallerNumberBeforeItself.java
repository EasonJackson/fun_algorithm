import java.util.Stack;

/**
 * Created by easonjackson on 1/15/18.
 */
public class CountSmallerNumberBeforeItself {

    public static void main(String[] args) {
        int[] input = {1, 3, 5, 7, 10, 4, 2, 9};
        Solution solution = new CountSmallerNumberBeforeItself().new Solution();
        int[] res = solution.countSmallerNumberBefore(input);
        for (int p : res) {
            System.out.print(p + " ");
        }
    }

    public class Solution {
        public int[] countSmallerNumberBefore(int[] input) {
            // Find the upper limit of Segment Tree
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < input.length; i++) {
                maxValue = Math.max(input[i], maxValue);
            }

            // Build a new Segment Tree with the upper limit
            // Initialize all values (sum) in the nodes to 0
            SegmentTreeNodePrototype root = buildSegmentTree(0, maxValue - 1);

            int[] res = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                res[i] = getSum(0, input[i] - 1, root);
                findAndUpdateSegTree(input[i], root);
            }

            return res;
        }
    }

    private SegmentTreeNodePrototype buildSegmentTree(int min, int max) {
        if (min == max) {
            return new SegmentTreeNodePrototype(min, max, 0);
        }

        int mid = min + (max - min) / 2;
        SegmentTreeNodePrototype node = new SegmentTreeNodePrototype(min, max, 0);
        node.leftNode = buildSegmentTree(min, mid);
        node.rightNode = buildSegmentTree(mid + 1, max);

        return node;
    }

    private void findAndUpdateSegTree(int index,
                                      SegmentTreeNodePrototype root) {
        Stack<SegmentTreeNodePrototype> stack = new Stack<>();
        SegmentTreeNodePrototype scan = root;
        while(scan != null) {
            stack.push(scan);
            if ((scan.start + scan.end)/2 + 1 > index) {
                scan = scan.leftNode;
            } else {
                scan = scan.rightNode;
            }
        }

        while(!stack.isEmpty()) {
            SegmentTreeNodePrototype node = stack.pop();
            node.value += 1;
        }

        return;
    }

    private int getSum(int start,
                       int end,
                       SegmentTreeNodePrototype root) {
        if (root.start == start && root.end == end) {
            return root.value;
        }

        int mid = root.start + (root.end - root.start) / 2;
        if (end <= mid) {
            return getSum(start, end, root.leftNode);
        } else if (start > mid) {
            return getSum(start, end, root.rightNode);
        } else {
            return getSum(start, mid, root.leftNode) + getSum(mid + 1, end, root.rightNode);
        }
    }
}
