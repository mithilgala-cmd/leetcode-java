class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] balance = new int[n + 1];
        balance[0] = 0;

        for (int i = 0; i < n; i++) {
            balance[i + 1] = balance[i] + (nums[i] == target ? 1 : -1);
        }

        int[] sorted = balance.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < sorted.length; i++) {
            index.put(sorted[i], i + 1); 
        }

        FenwickTree bit = new FenwickTree(sorted.length);
        long ans = 0;

        for (int b : balance) {
            int pos = index.get(b);
            ans += bit.query(pos - 1);
            bit.update(pos, 1);
        }
        return ans;
    }

    static class FenwickTree {
        long[] tree;
        FenwickTree(int n) { tree = new long[n + 1]; }
        void update(int i, int delta) {
            while (i < tree.length) {
                tree[i] += delta;
                i += i & -i;
            }
        }
        long query(int i) {
            long sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }
    }
}