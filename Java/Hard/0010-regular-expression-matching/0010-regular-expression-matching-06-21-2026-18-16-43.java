class Solution {
    public boolean isMatch(String s, String p) {
        return dfs(0, 0, s, p, new Boolean[s.length()+1][p.length()+1]);
    }

    private boolean dfs(int i, int j, String s, String p, Boolean[][] memo) {
        if (memo[i][j] != null) return memo[i][j];
        if (j == p.length()) return memo[i][j] = (i == s.length());
        boolean first = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
        if (j+1 < p.length() && p.charAt(j+1) == '*')
            return memo[i][j] = (dfs(i, j+2, s, p, memo) || (first && dfs(i+1, j, s, p, memo)));
        return memo[i][j] = (first && dfs(i+1, j+1, s, p, memo));
    }
}