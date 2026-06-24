class Solution {
    public int minimumChairs(String s) {
        int current = 0, max = 0;
        for (char c : s.toCharArray()) {
            if (c == 'E') current++;
            else current--;
            max = Math.max(max, current);
        }
        return max;
    }
}