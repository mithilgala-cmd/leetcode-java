class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxRowIndex = 0;
        int maxOnesCount = 0;

        for (int i = 0; i < mat.length; i++) {
            int currentOnes = 0;
            for (int val : mat[i]) {
                currentOnes += val;
            }

            if (currentOnes > maxOnesCount) {
                maxOnesCount = currentOnes;
                maxRowIndex = i;
            }
        }

        return new int[]{maxRowIndex, maxOnesCount};
    }
}