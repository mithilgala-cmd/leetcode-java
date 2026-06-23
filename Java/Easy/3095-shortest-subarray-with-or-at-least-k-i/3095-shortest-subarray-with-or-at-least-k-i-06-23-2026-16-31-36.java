class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int or = 0;
            for (int j = i; j < n; j++) {
                or |= nums[j];
                if (or >= k) {
                    ans = Math.min(ans, j - i + 1);
                    break; 
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}