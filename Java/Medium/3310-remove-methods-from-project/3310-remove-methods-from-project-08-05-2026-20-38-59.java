class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : invocations) graph.get(e[0]).add(e[1]);
        boolean[] sus = new boolean[n];
        dfs(k, graph, sus);
        for (int[] e : invocations) {
            if (!sus[e[0]] && sus[e[1]]) {
                List<Integer> all = new ArrayList<>();
                for (int i = 0; i < n; i++) all.add(i);
                return all;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) if (!sus[i]) res.add(i);
        return res;
    }

    private void dfs(int u, List<List<Integer>> graph, boolean[] sus) {
        if (sus[u]) return;
        sus[u] = true;
        for (int v : graph.get(u)) dfs(v, graph, sus);
    }
}