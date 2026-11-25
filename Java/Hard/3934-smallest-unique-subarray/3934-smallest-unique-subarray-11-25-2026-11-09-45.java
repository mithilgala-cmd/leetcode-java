class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int low = 1, high = n, ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(nums, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean isValid(int[] nums, int len) {
        long mod1 = 1000000007L, mod2 = 1000000009L;
        long base1 = 1315423911L, base2 = 2654435761L;
        long h1 = 0, h2 = 0, p1 = 1, p2 = 1;

        for (int i = 0; i < len; i++) {
            h1 = (h1 * base1 + nums[i]) % mod1;
            h2 = (h2 * base2 + nums[i]) % mod2;
            if (i > 0) {
                p1 = (p1 * base1) % mod1;
                p2 = (p2 * base2) % mod2;
            }
        }

        Map<Long, Integer> freq = new HashMap<>();
        freq.put((h1 << 32) | h2, 1);

        for (int i = len; i < nums.length; i++) {
            h1 = ((h1 - (nums[i - len] * p1) % mod1 + mod1) * base1 + nums[i]) % mod1;
            h2 = ((h2 - (nums[i - len] * p2) % mod2 + mod2) * base2 + nums[i]) % mod2;
            long key = (h1 << 32) | h2;
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }

        for (int count : freq.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}