class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i + k <= nums.length; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i; j < i + k; j++) seen.add(nums[j]);
            for (int x : seen) map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int res = -1;
        for (int x : map.keySet()) if (map.get(x) == 1) res = Math.max(res, x);
        return res;
    }
}