class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] res = dfs(i, adj, visited);
                int v = res[0], e = res[1] / 2;
                if (e == v * (v - 1) / 2) ans++;
            }
        }
        return ans;
    }

    private int[] dfs(int u, List<List<Integer>> adj, boolean[] visited) {
        Stack<Integer> st = new Stack<>();
        st.push(u);
        visited[u] = true;
        int v = 0, e = 0;
        while (!st.isEmpty()) {
            int x = st.pop();
            v++;
            e += adj.get(x).size();
            for (int nei : adj.get(x)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    st.push(nei);
                }
            }
        }
        return new int[]{v, e};
    }
}