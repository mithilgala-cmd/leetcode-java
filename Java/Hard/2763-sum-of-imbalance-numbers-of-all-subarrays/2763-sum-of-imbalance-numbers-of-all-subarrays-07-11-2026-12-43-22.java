class Solution {
    public int sumImbalanceNumbers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 2];
            int imbalance = 0;

            for (int j = i; j < n; j++) {
                int x = nums[j];

                if (!seen[x]) {
                    if (seen[x - 1] && seen[x + 1]) {
                        imbalance--;
                    }
                    else if (!seen[x - 1] && !seen[x + 1] && j > i) {
                        imbalance++;
                    }
                    seen[x] = true;
                }
                ans += imbalance;
            }
        }
        return ans;
    }
}