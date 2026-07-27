class Solution {
    public int largestComponentSize(int[] nums) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);
        int[] parent = new int[max + 1];
        for (int i = 0; i <= max; i++) parent[i] = i;
        for (int x : nums) {
            for (int f = 2; f * f <= x; f++) {
                if (x % f == 0) {
                    union(parent, x, f);
                    union(parent, x, x / f);
                }
            }
        }
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int x : nums) {
            int root = find(parent, x);
            count.put(root, count.getOrDefault(root, 0) + 1);
            ans = Math.max(ans, count.get(root));
        }
        return ans;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private void union(int[] parent, int a, int b) {
        int pa = find(parent, a), pb = find(parent, b);
        if (pa != pb) parent[pa] = pb;
    }
}