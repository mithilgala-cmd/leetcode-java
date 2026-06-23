class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int ops = 0;
        for (int num : nums) {
            if (num < k) ops++;
            else break;
        }
        return ops;
    }
}