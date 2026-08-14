class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        Integer[][][] dp = new Integer[n][n][n];
        return Math.max(0, dfs(0,0,0,grid,dp));
    }

    private int dfs(int r1, int c1, int r2, int[][] grid, Integer[][][] dp) {
        int n = grid.length;
        int c2 = r1 + c1 - r2;
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n) return -1;
        if (grid[r1][c1] == -1 || grid[r2][c2] == -1) return -1;
        if (r1 == n-1 && c1 == n-1) return grid[r1][c1];
        if (dp[r1][c1][r2] != null) return dp[r1][c1][r2];
        int cherries = grid[r1][c1];
        if (r1 != r2 || c1 != c2) cherries += grid[r2][c2];
        int best = Math.max(
            Math.max(dfs(r1+1,c1,r2+1,grid,dp), dfs(r1+1,c1,r2,grid,dp)),
            Math.max(dfs(r1,c1+1,r2+1,grid,dp), dfs(r1,c1+1,r2,grid,dp))
        );
        if (best == -1) dp[r1][c1][r2] = -1;
        else dp[r1][c1][r2] = cherries + best;
        return dp[r1][c1][r2];
    }
}