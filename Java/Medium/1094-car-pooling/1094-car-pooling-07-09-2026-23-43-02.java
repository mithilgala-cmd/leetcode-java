class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int max = 0;
        for (int[] trip : trips) {
            max = Math.max(max, trip[2]);
        }
        
        int[] diff = new int[max + 1];
        
        for (int[] trip : trips) {
            int num = trip[0], from = trip[1], to = trip[2];
            diff[from] += num;
            diff[to] -= num;
        }
        
        int curr = 0;
        for (int i = 0; i <= max; i++) {
            curr += diff[i];
            if (curr > capacity) return false;
        }        
        return true;
    }
}