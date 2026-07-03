class Solution {
    public int longestString(int x, int y, int z) {
        int base = Math.min(x, y) * 2;
        if (x != y) base++;
        return (base + z) * 2;
    }
}