class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int dx = Math.abs(fx - sx);
        int dy = Math.abs(fy - sy);

        int minTime = Math.max(dx, dy);

        if (dx == 0 && dy == 0 && t == 1) {
            return false;
        }
        return minTime <= t;
    }
}
