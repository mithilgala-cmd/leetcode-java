class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        int remainder = sum % k;
        return remainder == 0 ? 0 : remainder;
    }
}