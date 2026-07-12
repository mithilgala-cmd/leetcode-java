class FindSumPairs {
    int[] nums1, nums2;
    Map<Integer, Integer> freq;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;

        freq = new HashMap<>();
        for (int x : nums2) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
    }

    public void add(int index, int val) {
        freq.put(nums2[index], freq.get(nums2[index]) - 1);

        nums2[index] += val;

        freq.put(nums2[index], freq.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int ans = 0;

        for (int x : nums1) {
            ans += freq.getOrDefault(tot - x, 0);
        }

        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index, val);
 * int param_2 = obj.count(tot);
 */