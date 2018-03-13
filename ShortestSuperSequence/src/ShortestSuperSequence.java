/**
 * Created by easonjackson on 1/30/18.
 */
public class ShortestSuperSequence {

    public static String shortestSuperSequence(String[] input) {
        String res = "";

        res = divideAndConquer(input, 0, input.length - 1);

        return res;
    }

    private static String divideAndConquer(String[] input, int start, int end) {
        if (start == end) {
            return input[start];
        }

        int mid = start + (end - start) >>> 1;
        String left = divideAndConquer(input, start, mid);
        String right = divideAndConquer(input, mid + 1, end);

        return findSuperSequence(left, right);
    }

    private static String findSuperSequence(String left, String right) {
        int[][] dp = new int[left.length() + 1][right.length() + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < left.length(); i++) {
            for (int j = 0; j < right.length(); j++) {
                if (left.charAt(i) == right.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;

                }
            }
        }
    }
}
