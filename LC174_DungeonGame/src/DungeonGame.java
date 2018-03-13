import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by easonjackson on 2/8/18.
 */
public class DungeonGame {

    class Strategy {
        int require;
        int supply;
        Strategy(int require, int supply) {
            this.require = require;
            this.supply = supply;
        }
    }

    private static Comparator<Strategy> strategyComparator = new Comparator<Strategy>() {
        @Override
        public int compare(Strategy st1, Strategy st2) {
            if (st1.require != st2.require) {
                return st1.require - st2.require;
            } else {
                return st2.supply - st1.supply;
            }
        }
    };

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }

        List<Strategy>[] dp = new List<Strategy>[dungeon[0].length];
        dp[0] = new ArrayList<>();
        Strategy strategy = new Strategy(Math.max(0, 1 - dungeon[0][0]), Math.max(0, dungeon[0][0]));
        dp[0].add(strategy);

        for (int col = 1; col < dungeon[0].length; col++) {
            Strategy pre_stra = dp[col - 1].get(0);
            Strategy curr_stra = new Strategy(pre_stra.require, pre_stra.supply);
            if (dungeon[0][col] >= 0) {
                curr_stra.supply += dungeon[0][col];
            } else if (curr_stra.supply + dungeon[0][col] >= 0) {
                curr_stra.supply += dungeon[0][col];
            } else {
                curr_stra.require -= curr_stra.supply + dungeon[0][col];
            }
            dp[0][col].add(curr_stra);
        }

        for (int row = 1; row < dungeon.length; row++) {
            for (int col = 0; col < dungeon[0].length; col++) {
                if (col == 0) {
                    Strategy pre_stra = dp[row - 1][0].get(0);
                    Strategy curr_stra = new Strategy(pre_stra.require, pre_stra.supply);
                    if (dungeon[row][col] >= 0) {
                        curr_stra.supply += dungeon[row][col];
                    } else if (curr_stra.supply + dungeon[row][col] >= 0) {
                        curr_stra.supply += dungeon[row][col];
                    } else {
                        curr_stra.require -= curr_stra.supply + dungeon[row][col];
                    }
                    dp[row][col].add(curr_stra);
                } else {
                    findBestStrategy(dp[row][col - 1], dp[row - 1][col], dp[row][col]);
                }
            }
        }

        return dp[dungeon.length - 1][dungeon[0].length - 1].get(0).require;
    }

    private void findBestStrategy(List<Strategy> left, List<Strategy> up, List<Strategy> curr) {
        PriorityQueue<Strategy> minheap = new PriorityQueue<Strategy>(this.strategyComparator);
        for (Strategy st1 : left) {
            minheap.offer(st1);
        }

        for (Strategy st2 : up) {
            minheap.offer(st2);
        }

        Strategy pre = minheap.poll();
        while (!minheap.isEmpty()) {
            if (curr.size() == 0) {
                curr.add(pre);
            } else {

            }
        }
    }
}
