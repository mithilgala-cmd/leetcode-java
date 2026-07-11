class Solution {
    public int minChanges(int[] nums, int k) {
        int n = nums.length;

        int[] oneChangeLimit = new int[k + 1];
        int[] freq = new int[k + 1];

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];

            int d = Math.abs(a - b);
            freq[d]++;

            int mx = Math.max(
                Math.max(a, b),
                Math.max(k - a, k - b)
            );

            oneChangeLimit[mx]++;
        }

        int ans = Integer.MAX_VALUE;
        int oneChangePairs = 0;
        int totalPairs = n / 2;

        for (int x = k; x >= 0; x--) {
            oneChangePairs += oneChangeLimit[x];

            int zeroChanges = freq[x];
            int oneChanges = oneChangePairs - zeroChanges;
            int twoChanges = totalPairs - oneChangePairs;

            ans = Math.min(ans, oneChanges + 2 * twoChanges);
        }
        return ans;
    }
}