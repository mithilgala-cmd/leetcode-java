class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final int MOD = 1_000_000_007;
        int[] bitCounts = new int[31];

        for (int num : nums) {
            for (int i = 0; i < 30; i++) {
                if (((num >> i) & 1) == 1) {
                    bitCounts[i]++;
                }
            }
        }

        long totalSum = 0;

        for (int step = 0; step < k; step++) {
            long currentVal = 0;
            for (int i = 0; i < 30; i++) {
                if (bitCounts[i] > 0) {
                    currentVal |= (1L << i);
                    bitCounts[i]--;
                }
            }
            totalSum = (totalSum + (currentVal * currentVal) % MOD) % MOD;
        }
        return (int) totalSum;
    }
}