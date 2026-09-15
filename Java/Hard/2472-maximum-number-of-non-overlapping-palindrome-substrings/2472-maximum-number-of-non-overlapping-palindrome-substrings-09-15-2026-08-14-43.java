class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        for (int center = 0; center < n; center++) {
            expand(s, center, center, isPal);
            expand(s, center, center + 1, isPal);
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            for (int j = i - k; j >= 0; j--) {
                if (isPal[j][i - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    break;
                }
            }
        }
        return dp[n];
    }

    private void expand(String s, int l, int r, boolean[][] isPal) {
        int n = s.length();
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            isPal[l][r] = true;
            l--;
            r++;
        }
    }
}