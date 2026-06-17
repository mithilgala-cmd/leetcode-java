class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String s : sentences) {
            int words = s.split(" ").length;
            if (words > max) max = words;
        }
        return max;
    }
} 