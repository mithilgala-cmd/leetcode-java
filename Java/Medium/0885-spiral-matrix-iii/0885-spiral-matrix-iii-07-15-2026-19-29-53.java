class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int total = rows * cols;
        int[][] res = new int[total][2];
        int count = 0;
        int len = 1;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int r = rStart, c = cStart;
        while (count < total) {
            for (int d = 0; d < 4; d++) {
                for (int k = 0; k < len; k++) {
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        res[count][0] = r;
                        res[count][1] = c;
                        count++;
                        if (count == total) return res;
                    }
                    r += dirs[d][0];
                    c += dirs[d][1];
                }
                if (d % 2 == 1) len++;
            }
        }
        return res;
    }
}