class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int left = 0, ones = 0;
        String res = "";
        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') ones++;
            while (ones >= k) {
                if (ones == k) {
                    String cur = s.substring(left, right + 1);
                    if (res.isEmpty() || cur.length() < res.length() || 
                       (cur.length() == res.length() && cur.compareTo(res) < 0)) {
                        res = cur;
                    }
                }
                if (s.charAt(left) == '1') ones--;
                left++;
            }
        }
        return res;
    }
}