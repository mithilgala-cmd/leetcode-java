class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1 + dp[i + 1];
            for (int len = 1; i + len <= n; len++) {
                if (dict.contains(s.substring(i, i + len))) {
                    dp[i] = Math.min(dp[i], dp[i + len]);
                }
            }
        }
        return dp[0];
    }
}