class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }

        int[] newParent = Arrays.copyOf(parent, n);
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        findNewParents(0, adj, s, lastSeen, newParent);

        List<Integer>[] newAdj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            newAdj[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            newAdj[newParent[i]].add(i);
        }

        int[] answer = new int[n];
        calculateSizes(0, newAdj, answer);
        return answer;
    }

    private void findNewParents(int node, List<Integer>[] adj, String s, int[] lastSeen, int[] newParent) {
        int charIdx = s.charAt(node) - 'a';
        int prevAncestor = lastSeen[charIdx];

        if (prevAncestor != -1) {
            newParent[node] = prevAncestor;
        }

        lastSeen[charIdx] = node;
        for (int child : adj[node]) {
            findNewParents(child, adj, s, lastSeen, newParent);
        }
        lastSeen[charIdx] = prevAncestor;
    }

    private int calculateSizes(int node, List<Integer>[] newAdj, int[] answer) {
        int size = 1;
        for (int child : newAdj[node]) {
            size += calculateSizes(child, newAdj, answer);
        }
        answer[node] = size;
        return size;
    }
}