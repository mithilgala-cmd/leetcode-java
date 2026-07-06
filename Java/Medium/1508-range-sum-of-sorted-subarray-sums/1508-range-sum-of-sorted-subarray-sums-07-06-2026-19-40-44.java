class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int MOD = 1_000_000_007;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        List<Integer> subSums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                subSums.add(prefix[j] - prefix[i]);
            }
        }
        
        Collections.sort(subSums);
        
        long result = 0;
        for (int i = left - 1; i < right; i++) {
            result = (result + subSums.get(i)) % MOD;
        }
        
        return (int) result;
    }
}