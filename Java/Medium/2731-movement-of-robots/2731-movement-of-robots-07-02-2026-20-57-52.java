class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length;
        long MOD = 1000000007;
        long[] pos = new long[n];
        for (int i = 0; i < n; i++) {
            pos[i] = s.charAt(i) == 'L' ? (long)nums[i] - d : (long)nums[i] + d;
        }
        Arrays.sort(pos);
        long ans = 0, prefix = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (pos[i] * i - prefix)) % MOD;
            prefix += pos[i];
        }
        return (int)ans;
    }
}