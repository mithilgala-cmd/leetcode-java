class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] p = new int[n][2];

        for (int i = 0; i < n; i++) {
            p[i][0] = capital[i];
            p[i][1] = profits[i];
        }

        Arrays.sort(p, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int i = 0;

        while (k-- > 0) {
            while (i < n && p[i][0] <= w) {
                pq.offer(p[i][1]);
                i++;
            }
            if (pq.isEmpty()) {
                break;
            }
            w += pq.poll();
        }
        return w;
    }
}