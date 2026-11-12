class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        Map<Integer, Integer> firstIndex = new HashMap<>();
        Map<Integer, Integer> lastIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int val = nums[i];
            if (lastIndex.containsKey(val)) {
                int prev = lastIndex.get(val);
                int dist = i - prev;
                minDist[i] = Math.min(minDist[i], dist);
                minDist[prev] = Math.min(minDist[prev], dist);
            } else {
                firstIndex.put(val, i);
            }
            lastIndex.put(val, i);
        }

        for (Map.Entry<Integer, Integer> entry : firstIndex.entrySet()) {
            int val = entry.getKey();
            int first = entry.getValue();
            int last = lastIndex.get(val);
            if (first != last) {
                int wrapDist = n - last + first;
                minDist[first] = Math.min(minDist[first], wrapDist);
                minDist[last] = Math.min(minDist[last], wrapDist);
            }
        }

        List<Integer> ans = new ArrayList<>(queries.length);
        for (int q : queries) {
            ans.add(minDist[q] == Integer.MAX_VALUE ? -1 : minDist[q]);
        }
        return ans;
    }
}