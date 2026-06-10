class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return 0;

        int maxLog = (int)(Math.log(n) / Math.log(2)) + 1;
        int[][] stMax = new int[n][maxLog];
        int[][] stMin = new int[n][maxLog];

        for (int i = 0; i < n; i++) {
            stMax[i][0] = nums[i];
            stMin[i][0] = nums[i];
        }
        for (int j = 1; j < maxLog; j++) {
            int half = 1 << (j - 1);
            for (int i = 0; i + (1 << j) <= n; i++) {
                stMax[i][j] = Math.max(stMax[i][j-1], stMax[i + half][j-1]);
                stMin[i][j] = Math.min(stMin[i][j-1], stMin[i + half][j-1]);
            }
        }

        int[] logTable = new int[n + 1];
        for (int i = 2; i <= n; i++)
            logTable[i] = logTable[i / 2] + 1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        Set<String> visited     = new HashSet<>();
        pq.offer(new int[]{getVal(stMax, stMin, logTable, 0, n-1), 0, n-1});
        visited.add("0," + (n-1));

        long totalValue = 0;

        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()) break;
            int[] curr  = pq.poll();
            int L = curr[1], R = curr[2];
            totalValue += curr[0];

            if (L + 1 <= R) {
                String key = (L+1) + "," + R;
                if (!visited.contains(key)) {
                    visited.add(key);
                    pq.offer(new int[]{getVal(stMax, stMin, logTable, L+1, R), L+1, R});
                }
            }
            if (L <= R - 1) {
                String key = L + "," + (R-1);
                if (!visited.contains(key)) {
                    visited.add(key);
                    pq.offer(new int[]{getVal(stMax, stMin, logTable, L, R-1), L, R-1});
                }
            }
        }
        return totalValue;
    }

    private int getVal(int[][] stMax, int[][] stMin, int[] logTable, int L, int R) {
        if (L > R) return 0;
        int j       = logTable[R - L + 1];
        int maxVal  = Math.max(stMax[L][j], stMax[R - (1 << j) + 1][j]);
        int minVal  = Math.min(stMin[L][j], stMin[R - (1 << j) + 1][j]);
        return maxVal - minVal;
    }
}