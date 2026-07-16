class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) freq[ch - 'a']++;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < 26; i++) if (freq[i] > 0) pq.offer(i);
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            int use = Math.min(freq[cur], repeatLimit);
            for (int i = 0; i < use; i++) sb.append((char)(cur + 'a'));
            freq[cur] -= use;
            if (freq[cur] > 0) {
                if (pq.isEmpty()) break;
                int next = pq.poll();
                sb.append((char)(next + 'a'));
                freq[next]--;
                if (freq[next] > 0) pq.offer(next);
                pq.offer(cur);
            }
        }
        return sb.toString();
    }
}