class Solution {
    public int maxArea(int[] h) {
        int l = 0, r = h.length - 1;
        int max = 0;
        
        while (l < r) {
            int height = Math.min(h[l], h[r]);
            int width = r - l;
            max = Math.max(max, height * width);
            
            if (h[l] < h[r]) l++;
            else r--;
        }
        
        return max;
    }
}