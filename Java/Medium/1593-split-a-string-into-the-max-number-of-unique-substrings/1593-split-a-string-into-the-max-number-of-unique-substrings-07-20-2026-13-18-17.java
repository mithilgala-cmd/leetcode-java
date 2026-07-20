class Solution {
    public int maxUniqueSplit(String s) {
        return dfs(s, 0, new HashSet<>());
    }
    private int dfs(String s, int idx, Set<String> seen) {
        if (idx == s.length()) return seen.size();
        int max = 0;
        for (int i = idx + 1; i <= s.length(); i++) {
            String sub = s.substring(idx, i);
            if (!seen.contains(sub)) {
                seen.add(sub);
                max = Math.max(max, dfs(s, i, seen));
                seen.remove(sub);
            }
        }
        return max;
    }
}