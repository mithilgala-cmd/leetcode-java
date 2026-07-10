class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && dfs(grid, visited, i, j, -1, -1, grid[i][j])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] visited, int i, int j, int pi, int pj, char c) {
        if (visited[i][j]) return true;
        visited[i][j] = true;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] d : dirs) {
            int ni = i + d[0], nj = j + d[1];
            if (ni < 0 || nj < 0 || ni >= grid.length || nj >= grid[0].length) continue;
            if (grid[ni][nj] != c) continue;
            if (ni == pi && nj == pj) continue;
            if (dfs(grid, visited, ni, nj, i, j, c)) return true;
        }
        return false;
    }
}