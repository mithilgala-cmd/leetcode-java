class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) if (x % k == 0) set.add(x);
        int m = k;
        while (true) {
            if (!set.contains(m)) return m;
            m += k;
        }
    }
}