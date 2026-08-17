class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + stoneValue[i];
        int[][] dp = new int[n][n];
        return solve(0, n - 1, prefix, dp);
    }

    private int solve(int l, int r, int[] prefix, int[][] dp) {
        if (l == r) return 0;
        if (dp[l][r] != 0) return dp[l][r];
        int res = 0;
        for (int m = l; m < r; m++) {
            int left = prefix[m + 1] - prefix[l];
            int right = prefix[r + 1] - prefix[m + 1];
            if (left < right) res = Math.max(res, left + solve(l, m, prefix, dp));
            else if (left > right) res = Math.max(res, right + solve(m + 1, r, prefix, dp));
            else res = Math.max(res, Math.max(left + solve(l, m, prefix, dp), right + solve(m + 1, r, prefix, dp)));
        }
        return dp[l][r] = res;
    }
}