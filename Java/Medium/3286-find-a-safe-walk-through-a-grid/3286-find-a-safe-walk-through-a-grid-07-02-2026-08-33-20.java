public class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[][] minCost = new int[m][n];
        for (int[] row : minCost) Arrays.fill(row, Integer.MAX_VALUE);
        minCost[0][0] = grid.get(0).get(0);
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerFirst(new int[]{0, 0});
        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int r = curr[0], c = curr[1];
            if (r == m - 1 && c == n - 1) break;
            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int nextCost = minCost[r][c] + grid.get(nr).get(nc);
                    if (nextCost < minCost[nr][nc]) {
                        minCost[nr][nc] = nextCost;
                        if (grid.get(nr).get(nc) == 0) deque.offerFirst(new int[]{nr, nc});
                        else deque.offerLast(new int[]{nr, nc});
                    }
                }
            }
        }
        return minCost[m - 1][n - 1] < health;
    }
}