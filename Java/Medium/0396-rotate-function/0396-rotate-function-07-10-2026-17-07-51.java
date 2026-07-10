class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long sum = 0, f0 = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f0 += (long) i * nums[i];
        }
        long res = f0, curr = f0;
        for (int k = 1; k < n; k++) {
            curr = curr + sum - (long) n * nums[n - k];
            res = Math.max(res, curr);
        }
        return (int) res;
    }
}