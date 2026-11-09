class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int n = arrival.length;
        int[] requestCounts = new int[k];

        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            int time = arrival[i];
            int duration = load[i];

            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                available.add(busy.poll()[1]);
            }

            if (available.isEmpty()) {
                continue;
            }

            int targetServer = i % k;
            Integer chosen = available.ceiling(targetServer);
            if (chosen == null) {
                chosen = available.first();
            }

            available.remove(chosen);
            busy.offer(new int[]{time + duration, chosen});
            requestCounts[chosen]++;
        }

        int maxRequests = 0;
        for (int count : requestCounts) {
            maxRequests = Math.max(maxRequests, count);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requestCounts[i] == maxRequests) {
                result.add(i);
            }
        }
        return result;
    }
}