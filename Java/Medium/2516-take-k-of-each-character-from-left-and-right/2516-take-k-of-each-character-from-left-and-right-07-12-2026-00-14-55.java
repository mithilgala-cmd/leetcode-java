class Solution {
    public int takeCharacters(String s, int k) {
        if (k == 0) return 0;

        int[] total = new int[3];
        for (char c : s.toCharArray()) total[c - 'a']++;

        if (total[0] < k || total[1] < k || total[2] < k) return -1;

        int[] cnt = new int[3];
        int left = 0, maxWindow = 0;

        for (int right = 0; right < s.length(); right++) {
            cnt[s.charAt(right) - 'a']++;

            while (total[0] - cnt[0] < k ||
                   total[1] - cnt[1] < k ||
                   total[2] - cnt[2] < k) {
                cnt[s.charAt(left) - 'a']--;
                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return s.length() - maxWindow;
    }
}