class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] sq = new long[n];
        for (int i = 0; i < n; i++) {
            sq[i] = (long) nums[i] * nums[i];
        }
        
        java.util.Arrays.sort(sq);
        
        int negCount = n / 2;
        long sum = 0;
        
        for (int i = 0; i < negCount; i++) {
            sum -= sq[i];
        }
        for (int i = negCount; i < n; i++) {
            sum += sq[i];
        }        
        return sum;
    }
}