class Solution {
    private long comb(long n, long m, long k) {
        long res = 1;
        m = Math.min(m, n - m);
        for (long i = 1; i <= m; i++) {
            res = (res * (n - i + 1)) / i;
            if (res > k) return k + 1;
        }
        return res;
    }

    private long permutations(int rem, int[] bucket, long k) {
        long ways = 1;
        for (int i = 0; i < 26; i++) {
            if (bucket[i] == 0) continue;
            ways *= comb(rem, bucket[i], k);
            if (ways > k) break;
            rem -= bucket[i];
        }
        return ways;
    }

    public String smallestPalindrome(String s, long k) {
        int n = s.length(), half = n / 2;
        int[] bucket = new int[26];
        char mid = 0;
        for (int i = 0; i < n; i++) {
            bucket[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (bucket[i] % 2 == 1) mid = (char)('a' + i);
            bucket[i] /= 2;
        }

        StringBuilder left = new StringBuilder();
        long start = 1;
        for (int pos = 0; pos < half; pos++) {
            for (int c = 0; c < 26; c++) {
                if (bucket[c] == 0) continue;
                bucket[c]--;
                long ways = permutations(half - pos - 1, bucket, k);
                if (start + ways > k) {
                    left.append((char)('a' + c));
                    break;
                }
                bucket[c]++;
                start += ways;
            }
        }

        if (left.length() < half) return "";
        StringBuilder right = new StringBuilder(left).reverse();
        return mid == 0 ? left.toString() + right.toString() : left.toString() + mid + right.toString();
    }
}