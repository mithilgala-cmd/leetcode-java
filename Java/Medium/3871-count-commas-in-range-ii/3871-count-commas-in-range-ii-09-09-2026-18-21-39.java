class Solution {
    public long countCommas(long n) {
        long res = 0;
        int commas = 1;
        long lower = 1000; 
        
        while (lower <= n) {
            long upper = Math.min(n, lower * 1000 - 1);
            long count = upper - lower + 1;
            res += count * commas;
            lower *= 1000;
            commas++;
        }        
        return res;
    }
}