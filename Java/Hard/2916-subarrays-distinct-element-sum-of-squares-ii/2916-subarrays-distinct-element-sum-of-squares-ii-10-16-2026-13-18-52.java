class Solution {
    private static final int MOD = 1_000_000_007;

    private long[] sum;
    private long[] sumSq;
    private long[] lazy;

    private void pushDown(int node, int l, int r) {
        if (lazy[node] != 0) {
            long add = lazy[node];
            int mid = l + (r - l) / 2;

            int leftChild = 2 * node;
            int rightChild = 2 * node + 1;

            int leftLen = mid - l + 1;
            int rightLen = r - mid;

            sumSq[leftChild] = (sumSq[leftChild] + 2 * add % MOD * sum[leftChild] % MOD + add * add % MOD * leftLen) % MOD;
            sum[leftChild] = (sum[leftChild] + add * leftLen) % MOD;
            lazy[leftChild] = (lazy[leftChild] + add) % MOD;

            sumSq[rightChild] = (sumSq[rightChild] + 2 * add % MOD * sum[rightChild] % MOD + add * add % MOD * rightLen) % MOD;
            sum[rightChild] = (sum[rightChild] + add * rightLen) % MOD;
            lazy[rightChild] = (lazy[rightChild] + add) % MOD;

            lazy[node] = 0;
        }
    }

    private void update(int node, int l, int r, int ql, int qr, int val) {
        if (ql <= l && r <= qr) {
            int len = r - l + 1;
            sumSq[node] = (sumSq[node] + 2L * val % MOD * sum[node] % MOD + (long) val * val % MOD * len) % MOD;
            sum[node] = (sum[node] + (long) val * len) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
            return;
        }

        pushDown(node, l, r);
        int mid = l + (r - l) / 2;

        if (ql <= mid) {
            update(2 * node, l, mid, ql, qr, val);
        }
        if (qr > mid) {
            update(2 * node + 1, mid + 1, r, ql, qr, val);
        }

        sum[node] = (sum[2 * node] + sum[2 * node + 1]) % MOD;
        sumSq[node] = (sumSq[2 * node] + sumSq[2 * node + 1]) % MOD;
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sum = new long[4 * n];
        sumSq = new long[4 * n];
        lazy = new long[4 * n];

        int[] lastPos = new int[100001];
        java.util.Arrays.fill(lastPos, -1);

        long total = 0;

        for (int i = 0; i < n; i++) {
            int prev = lastPos[nums[i]];
            update(1, 0, n - 1, prev + 1, i, 1);
            total = (total + sumSq[1]) % MOD;
            lastPos[nums[i]] = i;
        }
        return (int) total;
    }
}