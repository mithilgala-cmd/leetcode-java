class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    q.add(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dirs) {
                int ni = cur[0] + d[0], nj = cur[1] + d[1];
                if (ni >= 0 && nj >= 0 && ni < n && nj < n && dist[ni][nj] == Integer.MAX_VALUE) {
                    dist[ni][nj] = dist[cur[0]][cur[1]] + 1;
                    q.add(new int[]{ni, nj});
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        pq.add(new int[]{0, 0, dist[0][0]});
        boolean[][] visited = new boolean[n][n];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[0], j = cur[1], safe = cur[2];
            if (i == n - 1 && j == n - 1) return safe;
            if (visited[i][j]) continue;
            visited[i][j] = true;

            for (int[] d : dirs) {
                int ni = i + d[0], nj = j + d[1];
                if (ni >= 0 && nj >= 0 && ni < n && nj < n && !visited[ni][nj]) {
                    pq.add(new int[]{ni, nj, Math.min(safe, dist[ni][nj])});
                }
            }
        }
        return 0;
    }
}