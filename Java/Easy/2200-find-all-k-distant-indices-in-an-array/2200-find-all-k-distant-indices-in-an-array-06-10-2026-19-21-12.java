class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                int start = Math.max(0, i - k);
                int end = Math.min(n - 1, i + k);
                for (int j = start; j <= end; j++) {
                    res.add(j);
                }
            }
        }
        Collections.sort(res);
        List<Integer> ans = new ArrayList<>();
        int prev = -1;
        for (int x : res) {
            if (x != prev) {
                ans.add(x);
                prev = x;
            }
        }
        return ans;
    }
}