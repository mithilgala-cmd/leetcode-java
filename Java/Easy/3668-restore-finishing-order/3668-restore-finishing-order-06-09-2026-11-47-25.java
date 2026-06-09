class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        Set<Integer> set = new HashSet<>();
        for (int f : friends) set.add(f);

        List<Integer> result = new ArrayList<>();
        for (int id : order) {
            if (set.contains(id)) result.add(id);
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) ans[i] = result.get(i);
        return ans;
    }
}