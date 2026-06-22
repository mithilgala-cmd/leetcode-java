class Solution {
    public int minimumRecolors(String blocks, int k) {
        int ans = k, white = 0;
        for (int i = 0; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') white++;
            if (i >= k && blocks.charAt(i - k) == 'W') white--;
            if (i >= k - 1) ans = Math.min(ans, white);
        }
        return ans;
    }
}