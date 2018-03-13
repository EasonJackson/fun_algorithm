import java.util.ArrayList;
import java.util.List;

/**
 * Created by easonjackson on 1/17/18.
 */
public class PathNode {

    protected class NodeDistPair {
        int distance;
        PathNode node;

        NodeDistPair(PathNode node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public String nodeName;
    public PathNode ancestor;
    public int shortestDist;
    public List<NodeDistPair> neighbors;

    PathNode(String nodeName) {
        this.nodeName = nodeName;
        this.ancestor = null;
        this.shortestDist = Integer.MAX_VALUE;
        this.neighbors = new ArrayList<>();
    }

    public void setAncestor(PathNode ancestor) {
        this.ancestor = ancestor;
    }

    public void addNeighborNode(PathNode node, int dist) {
        NodeDistPair ndP = new NodeDistPair(node, dist);
        this.neighbors.add(ndP);
    }
}
