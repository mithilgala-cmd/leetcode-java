class Solution {
    public int minMoves(int[] nums, int k) {
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) pos.add(i);
        }

        int m = pos.size();
        long[] prefix = new long[m + 1];
        for (int i = 0; i < m; i++) {
            prefix[i + 1] = prefix[i] + pos.get(i);
        }

        long ans = Long.MAX_VALUE;

        for (int i = 0; i + k - 1 < m; i++) {
            int mid = i + k / 2;
            long median = pos.get(mid);

            long left = median * (mid - i) - (prefix[mid] - prefix[i]);
            long right = (prefix[i + k] - prefix[mid + 1]) - median * (i + k - mid - 1);

            long moves = left + right;

            if (k % 2 == 0) {
                moves -= (long) (k / 2) * (k / 2);
            } else {
                moves -= (long) (k / 2) * (k / 2 + 1);
            }
            ans = Math.min(ans, moves);
        }
        return (int) ans;
    }
}