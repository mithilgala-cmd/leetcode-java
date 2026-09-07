class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1000000007;
        int n = s.length();
        int[] dp = new int[n + 1];
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int c = s.charAt(i - 1) - 'a';
            dp[i] = (int)((2L * dp[i - 1]) % MOD);
            if (lastSeen[c] != -1) {
                dp[i] = (dp[i] - dp[lastSeen[c] - 1] + MOD) % MOD;
            }
            lastSeen[c] = i;
        }
        return (dp[n] - 1 + MOD) % MOD;
    }
}