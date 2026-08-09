class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffix = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) suffix[i] = suffix[i + 1] + piles[i];
        Integer[][] dp = new Integer[n][n + 1];
        return helper(0, 1, piles, suffix, dp);
    }

    private int helper(int i, int M, int[] piles, int[] suffix, Integer[][] dp) {
        if (i >= piles.length) return 0;
        if (2 * M >= piles.length - i) return suffix[i];
        if (dp[i][M] != null) return dp[i][M];
        int res = 0;
        for (int x = 1; x <= 2 * M; x++) {
            res = Math.max(res, suffix[i] - helper(i + x, Math.max(M, x), piles, suffix, dp));
        }
        return dp[i][M] = res;
    }
}