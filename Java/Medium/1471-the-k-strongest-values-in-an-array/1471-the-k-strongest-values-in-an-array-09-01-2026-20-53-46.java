class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int m = arr[(n - 1) / 2];
        Integer[] temp = new Integer[n];
        for (int i = 0; i < n; i++) temp[i] = arr[i];
        Arrays.sort(temp, (a, b) -> {
            int diffA = Math.abs(a - m), diffB = Math.abs(b - m);
            if (diffA == diffB) return b - a;
            return diffB - diffA;
        });
        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = temp[i];
        return res;
    }
}