class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                res[i] = 0;
                continue;
            }

            int newIndex = (i + nums[i]) % n;

            if (newIndex < 0) {
                newIndex += n;
            }

            res[i] = nums[newIndex];
        }
        return res;
    }
}