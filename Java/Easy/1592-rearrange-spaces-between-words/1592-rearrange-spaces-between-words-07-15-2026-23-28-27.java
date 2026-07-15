class Solution {
    public String reorderSpaces(String text) {
        int spaces = 0;
        for (char ch : text.toCharArray()) if (ch == ' ') spaces++;
        String[] words = text.trim().split("\\s+");
        int n = words.length;
        if (n == 1) return words[0] + " ".repeat(spaces);
        int between = spaces / (n - 1), extra = spaces % (n - 1);
        return String.join(" ".repeat(between), words) + " ".repeat(extra);
    }
}