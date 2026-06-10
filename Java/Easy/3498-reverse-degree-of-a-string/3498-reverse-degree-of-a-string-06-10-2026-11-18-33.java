class Solution {
    public int reverseDegree(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int posInString = i + 1;
            int reverseIndex = 26 - (s.charAt(i) - 'a');
            total += reverseIndex * posInString;
        }
        return total;
    }
}