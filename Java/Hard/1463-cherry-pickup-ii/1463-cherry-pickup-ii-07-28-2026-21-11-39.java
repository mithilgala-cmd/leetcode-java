class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][][] dp = new int[rows][cols][cols];
        for (int[][] arr : dp) for (int[] a : arr) Arrays.fill(a, -1);
        return dfs(grid, 0, 0, cols - 1, dp);
    }

    private int dfs(int[][] grid, int r, int c1, int c2, int[][][] dp) {
        int rows = grid.length, cols = grid[0].length;
        if (c1 < 0 || c1 >= cols || c2 < 0 || c2 >= cols) return 0;
        if (dp[r][c1][c2] != -1) return dp[r][c1][c2];
        int cherries = grid[r][c1];
        if (c1 != c2) cherries += grid[r][c2];
        if (r < rows - 1) {
            int best = 0;
            for (int d1 = -1; d1 <= 1; d1++) {
                for (int d2 = -1; d2 <= 1; d2++) {
                    best = Math.max(best, dfs(grid, r + 1, c1 + d1, c2 + d2, dp));
                }
            }
            cherries += best;
        }
        return dp[r][c1][c2] = cherries;
    }
}