class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String low = Long.toString(start);
        String high = Long.toString(finish);
        int n = high.length();
        low = String.format("%" + n + "s", low).replace(' ', '0');
        int preLen = n - s.length();
        Long[][][] dp = new Long[preLen+1][2][2];
        return dfs(0, true, true, low, high, limit, s, preLen, dp);
    }

    private long dfs(int i, boolean tightLow, boolean tightHigh,
                     String low, String high, int limit, String s,
                     int preLen, Long[][][] dp) {
        if (i == preLen) {
            String suffixLow = low.substring(preLen);
            String suffixHigh = high.substring(preLen);
            String suffix = s;
            if ((suffix.compareTo(suffixLow) < 0 && tightLow) ||
                (suffix.compareTo(suffixHigh) > 0 && tightHigh)) return 0;
            for (char c : suffix.toCharArray()) if (c-'0' > limit) return 0;
            return 1;
        }
        int lo = tightLow ? low.charAt(i)-'0' : 0;
        int hi = tightHigh ? high.charAt(i)-'0' : limit;
        int tl = tightLow ? 1 : 0, th = tightHigh ? 1 : 0;
        if (dp[i][tl][th] != null) return dp[i][tl][th];
        long res = 0;
        for (int d = lo; d <= hi; d++) {
            if (d > limit) continue;
            res += dfs(i+1, tightLow && d==lo, tightHigh && d==hi,
                       low, high, limit, s, preLen, dp);
        }
        return dp[i][tl][th] = res;
    }
}