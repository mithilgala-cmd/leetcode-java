class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for (int[] row : image) {
            for (int i = 0; i < (n + 1) / 2; i++) {
                int j = n - 1 - i;
                int temp = row[i] ^ 1;
                row[i] = row[j] ^ 1;
                row[j] = temp;
            }
        }
        return image;
    }
}
