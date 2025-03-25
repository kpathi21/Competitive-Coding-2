//DP - Tabulation approach using 2D matrix
//TC: O(m*n), SC: O(m*n)

public class KnapSackDP {
    public static void main(String[] args) {
        int[] profit = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int capacity = 50;

        int m = weight.length;
        int n = capacity;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j]; //No choose case
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], profit[i - 1] + dp[i - 1][j - weight[i - 1]]);
                }
            }
        }

        int result = dp[m][n];
        System.out.println(result);
    }

}
