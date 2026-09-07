class Solution {
    public int maxOperations(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        int target = nums[0] + nums[1];
        int ops = 1; 
        for (int i = 2; i < n; i += 2) {
            if (i + 1 < n && nums[i] + nums[i + 1] == target) {
                ops++;
            } else {
                break;
            }
        }
        return ops;
    }
}