class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int radius = 0;
        for (int house : houses) {
            int idx = Arrays.binarySearch(heaters, house);
            if (idx < 0) {
                idx = -(idx + 1);
            }
            
            int dist1 = (idx < heaters.length) ? Math.abs(heaters[idx] - house) : Integer.MAX_VALUE;
            int dist2 = (idx > 0) ? Math.abs(house - heaters[idx - 1]) : Integer.MAX_VALUE;
            
            radius = Math.max(radius, Math.min(dist1, dist2));
        }
        return radius;
    }
}