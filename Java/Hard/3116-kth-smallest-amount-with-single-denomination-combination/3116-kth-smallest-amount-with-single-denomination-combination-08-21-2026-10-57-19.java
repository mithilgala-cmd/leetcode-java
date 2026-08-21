class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long lo = 1, hi = (long)1e18;
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            if (count(coins, mid) >= k) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private long count(int[] coins, long x) {
        long res = 0;
        int n = coins.length;
        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            int bits = Integer.bitCount(mask);
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    lcm = lcm(lcm, coins[i]);
                    if (lcm > x) break;
                }
            }
            if (lcm <= x) {
                if (bits % 2 == 1) res += x / lcm;
                else res -= x / lcm;
            }
        }
        return res;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}