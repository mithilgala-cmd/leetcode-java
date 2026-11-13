class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        long cost = 0;
        int r = n - 1;
        Deque<Integer> dq = new ArrayDeque<>();

        for (int l = n - 1; l >= 0; l--) {
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[l]) {
                int currIdx = dq.pollLast();
                int nextIdx = dq.isEmpty() ? r + 1 : dq.peekLast();
                cost += (long) (nums[l] - nums[currIdx]) * (nextIdx - currIdx);
            }
            dq.addLast(l);

            while (cost > k) {
                int maxIdx = dq.peekFirst();
                cost -= (nums[maxIdx] - nums[r]);
                if (maxIdx == r) {
                    dq.pollFirst();
                }
                r--;
            }
            ans += (r - l + 1);
        }
        return ans;
    }
}