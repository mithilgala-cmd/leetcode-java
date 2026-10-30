class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        long[][] dist = new long[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        char startLabel = labels.charAt(0);
        pq.offer(new long[]{0, 0, 1});
        dist[0][1] = 0;

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int u = (int) curr[1];
            int count = (int) curr[2];

            if (d > dist[u][count]) continue;
            if (u == n - 1) return (int) d;

            for (int[] neighbor : graph[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];
                char nextLabel = labels.charAt(v);

                int nextCount = (nextLabel == labels.charAt(u)) ? count + 1 : 1;
                if (nextCount > k) continue;

                if (d + weight < dist[v][nextCount]) {
                    dist[v][nextCount] = d + weight;
                    pq.offer(new long[]{d + weight, v, nextCount});
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int c = 1; c <= k; c++) {
            ans = (int) Math.min(ans, dist[n - 1][c]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}