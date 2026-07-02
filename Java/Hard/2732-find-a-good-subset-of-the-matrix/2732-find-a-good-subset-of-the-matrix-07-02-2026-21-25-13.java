class Solution {
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] masks = new int[m];
        for (int i = 0; i < m; i++) {
            int mask = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) mask |= (1 << j);
            }
            masks[i] = mask;
            if (mask == 0) return Arrays.asList(i); 
        }
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    return Arrays.asList(i, j); 
                }
            }
        }
        return new ArrayList<>(); 
    }
}