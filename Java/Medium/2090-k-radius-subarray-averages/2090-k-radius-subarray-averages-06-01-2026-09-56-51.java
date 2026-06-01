class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) res[i] = -1;

        if (k == 0) return nums;
        if (2 * k + 1 > n) return res;

        long sum = 0;
        int windowSize = 2 * k + 1;

        for (int i = 0; i < windowSize; i++) {
            sum += nums[i];
        }

        res[k] = (int)(sum / windowSize);

        for (int i = windowSize; i < n; i++) {
            sum += nums[i] - nums[i - windowSize];
            res[i - k] = (int)(sum / windowSize);
        }
        return res;
    }
}