class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];
        
        for (int len = 2; len <= n; len++) {
            List<Integer> divisors = new ArrayList<>();
            for (int d = 1; d * d <= len; d++) {
                if (len % d == 0) {
                    divisors.add(d);
                    if (d != 1 && d * d != len) {
                        divisors.add(len / d);
                    }
                }
            }
            
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                int minChanges = Integer.MAX_VALUE;
                for (int d : divisors) {
                    int changes = 0;
                    for (int offset = 0; offset < d; offset++) {
                        int left = i + offset;
                        int right = j - (d - 1 - offset);
                        while (left < right) {
                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }
                            left += d;
                            right -= d;
                        }
                    }
                    minChanges = Math.min(minChanges, changes);
                }
                cost[i][j] = minChanges;
            }
        }
        
        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 1000000);
        }
        dp[0][0] = 0;
        
        for (int p = 1; p <= k; p++) {
            for (int i = 2 * p; i <= n; i++) {
                for (int m = 2 * (p - 1); m <= i - 2; m++) {
                    dp[i][p] = Math.min(dp[i][p], dp[m][p - 1] + cost[m][i - 1]);
                }
            }
        }        
        return dp[n][k];
    }
}