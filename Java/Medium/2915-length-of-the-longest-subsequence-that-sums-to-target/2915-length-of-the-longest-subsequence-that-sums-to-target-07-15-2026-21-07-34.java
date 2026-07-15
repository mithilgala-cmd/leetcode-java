class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int x : nums) {
            for (int s = target; s >= x; s--) {
                if (dp[s - x] != -1) {
                    dp[s] = Math.max(dp[s], dp[s - x] + 1);
                }
            }
        }
        return dp[target];
    }
}