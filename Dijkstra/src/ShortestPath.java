import java.util.PriorityQueue;

/**
 * Created by easonjackson on 1/17/18.
 */
public class ShortestPath {

    public static void findShortestPath(PathNode start, PathNode target) {
        int minDist = 0;
        PriorityQueue<PathNode> heap = new PriorityQueue<>();
        start.shortestDist = 0;
        heap.offer(start);
        while (!heap.isEmpty()) {
            PathNode node = heap.poll();
            int currDist = node.shortestDist;
            for (PathNode.NodeDistPair ndP : node.neighbors) {
                if (currDist + ndP.distance < ndP.node.shortestDist) {
                    ndP.node.ancestor = node;
                    ndP.node.shortestDist = currDist + ndP.distance;
                }
                heap.offer(ndP.node);
            }
        }

        StringBuilder sb = new StringBuilder();
        PathNode scan = target;
        while (scan != start) {
            sb.append(new StringBuilder(scan.nodeName).reverse()).append("<-");
            scan = scan.ancestor;
        }
        System.out.print(sb.reverse().toString());
    }

}
