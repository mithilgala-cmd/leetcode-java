class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diffCount = new int[100001];
        long totalK = (long) k1 + k2;
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            diffCount[d]++;
            if (d > maxDiff) {
                maxDiff = d;
            }
        }

        for (int d = maxDiff; d > 0 && totalK > 0; d--) {
            if (diffCount[d] == 0) {
                continue;
            }

            long count = diffCount[d];
            if (totalK >= count) {
                diffCount[d - 1] += count;
                diffCount[d] = 0;
                totalK -= count;
            } else {
                diffCount[d - 1] += (int) totalK;
                diffCount[d] -= (int) totalK;
                totalK = 0;
            }
        }

        long ans = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (diffCount[d] > 0) {
                ans += (long) diffCount[d] * (long) d * d;
            }
        }
        return ans;
    }
}