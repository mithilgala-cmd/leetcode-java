class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int ops = 1; ops <= 60; ops++) {
            long val = (long) num1 - (long) ops * num2;
            if (val < ops) continue; // must be at least ops
            if (Long.bitCount(val) <= ops) return ops;
        }
        return -1;
    }
}