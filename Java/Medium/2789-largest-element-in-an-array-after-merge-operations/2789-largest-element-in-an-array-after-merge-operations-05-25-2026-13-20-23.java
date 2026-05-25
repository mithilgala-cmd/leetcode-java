class Solution {
    public long maxArrayValue(int[] nums) {
        long curr = nums[nums.length - 1];
        
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= curr) {
                curr += nums[i];
            } else {
                curr = nums[i];
            }
        }        
        return curr;
    }
}