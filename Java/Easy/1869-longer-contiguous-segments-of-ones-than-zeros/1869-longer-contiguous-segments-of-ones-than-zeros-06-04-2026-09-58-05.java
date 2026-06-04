class Solution {
    public boolean checkZeroOnes(String s) {
        int max1 = 0, max0 = 0;
        int c1 = 0, c0 = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                c1++;
                c0 = 0;
            } else {
                c0++;
                c1 = 0;
            }
            max1 = Math.max(max1, c1);
            max0 = Math.max(max0, c0);
        }
        return max1 > max0;
    }
}