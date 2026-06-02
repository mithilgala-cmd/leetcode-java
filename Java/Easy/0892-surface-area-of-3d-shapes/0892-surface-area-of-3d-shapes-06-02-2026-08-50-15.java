class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int area = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int h = grid[i][j];

                if (h > 0) {
                    area += 2; 

                    int front = (i == 0) ? 0 : grid[i - 1][j];
                    area += Math.max(h - front, 0);

                    int back = (i == n - 1) ? 0 : grid[i + 1][j];
                    area += Math.max(h - back, 0);

                    int left = (j == 0) ? 0 : grid[i][j - 1];
                    area += Math.max(h - left, 0);

                    int right = (j == n - 1) ? 0 : grid[i][j + 1];
                    area += Math.max(h - right, 0);
                }
            }
        }
        return area;
    }
}