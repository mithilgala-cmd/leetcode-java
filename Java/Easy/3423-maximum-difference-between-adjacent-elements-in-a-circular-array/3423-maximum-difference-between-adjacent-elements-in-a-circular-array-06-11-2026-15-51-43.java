class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            maxDiff = Math.max(maxDiff, Math.abs(nums[i] - nums[j]));
        }
        return maxDiff;
    }
}