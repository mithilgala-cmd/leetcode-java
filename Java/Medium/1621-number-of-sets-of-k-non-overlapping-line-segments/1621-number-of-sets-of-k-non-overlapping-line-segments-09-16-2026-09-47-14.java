class Solution {
    static final int MOD = 1000000007;
    public int numberOfSets(int n, int k) {
        long[] fact = new long[2 * n + 1];
        long[] inv = new long[2 * n + 1];
        fact[0] = 1;
        for (int i = 1; i < fact.length; i++) fact[i] = fact[i - 1] * i % MOD;
        inv[fact.length - 1] = pow(fact[fact.length - 1], MOD - 2);
        for (int i = fact.length - 2; i >= 0; i--) inv[i] = inv[i + 1] * (i + 1) % MOD;
        return (int) comb(n + k - 1, 2 * k, fact, inv);
    }
    private long comb(int n, int r, long[] fact, long[] inv) {
        if (r < 0 || r > n) return 0;
        return fact[n] * inv[r] % MOD * inv[n - r] % MOD;
    }
    private long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}