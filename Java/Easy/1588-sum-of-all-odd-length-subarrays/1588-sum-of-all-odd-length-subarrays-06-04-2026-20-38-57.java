class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            int total = (i + 1) * (n - i);
            int oddCount = (total + 1) / 2;

            totalSum += arr[i] * oddCount;
        }
        return totalSum;
    }
}