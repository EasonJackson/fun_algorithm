import java.util.*;

/**
 * Created by easonjackson on 2/8/18.
 */
public class SuperSequence {

    private StringBuilder sb;

    private class GraphNode {
        char val;
        boolean visited;
        Map<Character, GraphNode> neighbors;

        GraphNode(char val) {
            this.val = val;
            this.visited = false;
            this.neighbors = new TreeMap<>(Comparator.reverseOrder());
        }
    }

    public String findSuperSequence(String[] source) {
        if (source == null || source.length == 0) {
            return "";
        }

        sb = new StringBuilder();
        GraphNode[] listNodes = buildGraph(source);


        for (int i = listNodes.length - 1; i >= 0; i--) {
            GraphNode node = listNodes[i];
            if (node != null && !node.visited) {
                dfs(node);
            }
        }

        return sb.reverse().toString();
    }

    private GraphNode[] buildGraph(String[] source) {
        GraphNode[] res = new GraphNode[26];

        for (String s : source) {
            char head = s.charAt(0);
            if (res[head - 'a'] == null) {
                res[head - 'a'] = new GraphNode(head);
            }
            GraphNode pre = res[head - 'a'];
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (res[c - 'a'] == null) {
                    res[c - 'a'] = new GraphNode(c);
                }
                pre.neighbors.put(c, res[c - 'a']);
                pre = res[c - 'a'];
            }
        }
        System.out.println("Finish building graph");
        return res;
    }

    private void dfs(GraphNode node) {
        node.visited = true;

        if (node.neighbors.keySet().size() == 0) {
            sb.append(node.val);
            return;
        }

        for (char neiNo : node.neighbors.keySet()) {
            if (!node.neighbors.get(neiNo).visited) {
                dfs(node.neighbors.get(neiNo));
            }
        }

        sb.append(node.val);
    }
}
