class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) freq[c - 'a']++;
        Arrays.sort(freq);
        int pushes = 0, slot = 0;
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break;
            pushes += freq[i] * ((slot / 8) + 1);
            slot++;
        }
        return pushes;
    }
}