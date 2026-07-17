class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 1, right = (long)1e18, ans = right;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (canReduce(mid, mountainHeight, workerTimes)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    private boolean canReduce(long T, int mountainHeight, int[] workerTimes) {
        long total = 0;
        for (int w : workerTimes) {
            long x = (long)(Math.sqrt(1 + 8.0 * T / w) - 1) / 2;
            total += x;
            if (total >= mountainHeight) return true;
        }
        return total >= mountainHeight;
    }
}