class Solution {
    public int minimumOperations(int[] nums) {
        int ops = 0;
        for (int num : nums) {
            int rem = num % 3;
            ops += Math.min(rem, 3 - rem);
        }
        return ops;
    }
}