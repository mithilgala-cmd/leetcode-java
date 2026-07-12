class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        int n = queries.length;
        int[][] q = new int[n][2];

        for (int i = 0; i < n; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(q, (a, b) -> a[0] - b[0]);

        int[] ans = new int[n];
        int idx = 0, best = 0;

        for (int[] query : q) {
            while (idx < items.length && items[idx][0] <= query[0]) {
                best = Math.max(best, items[idx][1]);
                idx++;
            }

            ans[query[1]] = best;
        }

        return ans;
    }
}