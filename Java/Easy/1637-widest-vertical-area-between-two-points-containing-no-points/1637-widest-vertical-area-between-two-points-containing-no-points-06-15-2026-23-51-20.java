class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        int[] x = new int[n];
        for (int i = 0; i < n; i++) x[i] = points[i][0];
        Arrays.sort(x);
        int maxGap = 0;
        for (int i = 1; i < n; i++) {
            maxGap = Math.max(maxGap, x[i] - x[i - 1]);
        }
        return maxGap;
    }
}