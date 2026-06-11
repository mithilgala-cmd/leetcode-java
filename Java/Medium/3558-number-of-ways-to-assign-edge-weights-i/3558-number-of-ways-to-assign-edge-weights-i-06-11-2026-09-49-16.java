class Solution {
    static final int MOD = 1_000_000_007;

    public int dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        int max = 0;
        visited[node] = true;
        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                max = Math.max(dfs(neighbour, adj, visited), max);
            }
        }
        return max + 1;
    }

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n + 1];
        int maxdepth = dfs(1, adj, visited);
        return modPow(2, maxdepth - 2, MOD);
    }

    private int modPow(int base, int exp, int mod) {
        long result = 1, b = base;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * b) % mod;
            b = (b * b) % mod;
            exp >>= 1;
        }
        return (int) result;
    }
}