class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        StringBuilder left = new StringBuilder();
        char mid = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i] / 2; j++) left.append((char)('a' + i));
            if (freq[i] % 2 == 1 && mid == 0) mid = (char)('a' + i);
        }
        StringBuilder right = new StringBuilder(left).reverse();
        return mid == 0 ? left.toString() + right.toString() : left.toString() + mid + right.toString();
    }
}