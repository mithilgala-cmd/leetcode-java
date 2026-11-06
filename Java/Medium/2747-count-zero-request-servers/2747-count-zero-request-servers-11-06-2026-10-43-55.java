class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int k = queries.length;
        int m = logs.length;
        int[] ans = new int[k];

        int[][] sortedQueries = new int[k][2];
        for (int i = 0; i < k; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        int[] count = new int[n + 1];
        int activeServers = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < k; i++) {
            int queryTime = sortedQueries[i][0];
            int originalIdx = sortedQueries[i][1];
            int windowStart = queryTime - x;

            while (right < m && logs[right][1] <= queryTime) {
                int serverId = logs[right][0];
                if (count[serverId] == 0) {
                    activeServers++;
                }
                count[serverId]++;
                right++;
            }

            while (left < m && logs[left][1] < windowStart) {
                int serverId = logs[left][0];
                count[serverId]--;
                if (count[serverId] == 0) {
                    activeServers--;
                }
                left++;
            }

            ans[originalIdx] = n - activeServers;
        }
        return ans;
    }
}