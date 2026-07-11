class Solution {
    Long[][] dp;

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        dp = new Long[robot.size()][factory.length];
        return solve(0, 0, robot, factory);
    }

    private long solve(int i, int j, List<Integer> robot, int[][] factory) {
        if (i == robot.size()) return 0;
        if (j == factory.length) return (long)1e18;

        if (dp[i][j] != null) return dp[i][j];

        long ans = solve(i, j + 1, robot, factory);
        long cost = 0;

        for (int k = 0; k < factory[j][1] && i + k < robot.size(); k++) {
            cost += Math.abs((long)robot.get(i + k) - factory[j][0]);
            ans = Math.min(ans, cost + solve(i + k + 1, j + 1, robot, factory));
        }
        return dp[i][j] = ans;
    }
}