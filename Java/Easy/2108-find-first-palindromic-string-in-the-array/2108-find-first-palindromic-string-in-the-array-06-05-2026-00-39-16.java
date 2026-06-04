class Solution {
    public String firstPalindrome(String[] words) {
        for (String s : words) {
            int l = 0, r = s.length() - 1;
            boolean ok = true;

            while (l < r) {
                if (s.charAt(l++) != s.charAt(r--)) {
                    ok = false;
                    break;
                }
            }
            if (ok) return s;
        }
        return "";
    }
}