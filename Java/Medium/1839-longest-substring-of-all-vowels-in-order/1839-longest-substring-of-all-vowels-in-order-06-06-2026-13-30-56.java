class Solution {
    public int longestBeautifulSubstring(String word) {
        int maxLen = 0;
        int len = 1;
        int unique = 1;

        for (int i = 1; i < word.length(); i++) {

            if (word.charAt(i) >= word.charAt(i - 1)) {
                len++;

                if (word.charAt(i) > word.charAt(i - 1)) {
                    unique++;
                }
            } else {
                len = 1;
                unique = 1;
            }

            if (unique == 5) {
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}