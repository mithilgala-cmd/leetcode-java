class Solution {
    public int maxSum(int[] nums) {
        boolean[] seen = new boolean[101];
        int sum = 0;
        int maxVal = Integer.MIN_VALUE;
        boolean hasPositive = false;

        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
            if (num > 0 && !seen[num]) {
                seen[num] = true;
                sum += num;
                hasPositive = true;
            }
        }
        return hasPositive ? sum : maxVal;
    }
}