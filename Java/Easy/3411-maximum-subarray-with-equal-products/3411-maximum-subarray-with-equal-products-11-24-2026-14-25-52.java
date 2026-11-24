class Solution {
    public int maxLength(int[] nums) {
        int maxLen = 1;
        int n = nums.length;
        int maxLcm = 2520;

        for (int i = 0; i < n; i++) {
            int prod = 1;
            int gcd = 0;
            int lcm = 1;

            for (int j = i; j < n; j++) {
                prod *= nums[j];
                gcd = gcd(gcd, nums[j]);
                lcm = lcm(lcm, nums[j]);

                if (prod == lcm * gcd) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }

                if (prod > maxLcm * gcd) {
                    break;
                }
            }
        }
        return maxLen;
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    private int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}