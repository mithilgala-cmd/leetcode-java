class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int total = mean * (n + m);
        int known = 0;
        for (int r : rolls) known += r;
        int missingSum = total - known;

        if (missingSum < n || missingSum > 6 * n) return new int[]{};

        int[] ans = new int[n];
        int base = missingSum / n;
        int extra = missingSum % n;

        for (int i = 0; i < n; i++) {
            ans[i] = base + (i < extra ? 1 : 0);
        }
        return ans;
    }
}