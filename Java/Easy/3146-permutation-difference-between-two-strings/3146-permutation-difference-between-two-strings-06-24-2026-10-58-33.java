class Solution {
    public int findPermutationDifference(String s, String t) {
        int[] pos = new int[26];
        for (int i = 0; i < t.length(); i++) {
            pos[t.charAt(i) - 'a'] = i;
        }
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            diff += Math.abs(i - pos[s.charAt(i) - 'a']);
        }
        return diff;
    }
}