class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        boolean[] seenA = new boolean[n + 1];
        boolean[] seenB = new boolean[n + 1];
        int[] res = new int[n];
        int common = 0;
        for (int i = 0; i < n; i++) {
            seenA[A[i]] = true;
            seenB[B[i]] = true;
            if (seenB[A[i]]) common++;
            if (seenA[B[i]] && A[i] != B[i]) common++;
            res[i] = common;
        }
        return res;
    }
}