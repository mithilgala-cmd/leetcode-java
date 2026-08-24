class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int max = 0;
        for (int x : arr) max = Math.max(max, x);
        int cur = arr[0], win = 0;
        for (int i = 1; i < n; i++) {
            if (cur > arr[i]) win++;
            else {
                cur = arr[i];
                win = 1;
            }
            if (win == k) return cur;
        }
        return max;
    }
}