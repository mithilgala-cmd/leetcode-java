class Solution {
    int[][] dp;

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        dp = new int[n][n];
        return solve(values, 0, n - 1);
    }

    private int solve(int[] values, int i, int j) {
        if (j - i < 2) return 0;

        if (dp[i][j] != 0) return dp[i][j];

        dp[i][j] = Integer.MAX_VALUE;

        for (int k = i + 1; k < j; k++) {
            dp[i][j] = Math.min(
                dp[i][j],
                values[i] * values[j] * values[k]
                + solve(values, i, k)
                + solve(values, k, j)
            );
        }

        return dp[i][j];
    }
}