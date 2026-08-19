class BookMyShow {
    int n, m;
    long[] seats, next;
    long[] treeSum, treeMax;

    public BookMyShow(int n, int m) {
        this.n = n;
        this.m = m;
        seats = new long[n];
        Arrays.fill(seats, m);
        next = new long[n];
        treeSum = new long[4 * n];
        treeMax = new long[4 * n];
        build(1, 0, n - 1);
    }

    private void build(int idx, int l, int r) {
        if (l == r) {
            treeSum[idx] = seats[l];
            treeMax[idx] = seats[l];
            return;
        }
        int mid = (l + r) / 2;
        build(idx * 2, l, mid);
        build(idx * 2 + 1, mid + 1, r);
        treeSum[idx] = treeSum[idx * 2] + treeSum[idx * 2 + 1];
        treeMax[idx] = Math.max(treeMax[idx * 2], treeMax[idx * 2 + 1]);
    }

    private void update(int idx, int l, int r, int pos, long val) {
        if (l == r) {
            treeSum[idx] = val;
            treeMax[idx] = val;
            return;
        }
        int mid = (l + r) / 2;
        if (pos <= mid) update(idx * 2, l, mid, pos, val);
        else update(idx * 2 + 1, mid + 1, r, pos, val);
        treeSum[idx] = treeSum[idx * 2] + treeSum[idx * 2 + 1];
        treeMax[idx] = Math.max(treeMax[idx * 2], treeMax[idx * 2 + 1]);
    }

    private long querySum(int idx, int l, int r, int ql, int qr) {
        if (ql > r || qr < l) return 0;
        if (ql <= l && r <= qr) return treeSum[idx];
        int mid = (l + r) / 2;
        return querySum(idx * 2, l, mid, ql, qr) + querySum(idx * 2 + 1, mid + 1, r, ql, qr);
    }

    private int queryRow(int idx, int l, int r, int k, int maxRow) {
        if (l > maxRow || treeMax[idx] < k) return -1;
        if (l == r) return l;
        int mid = (l + r) / 2;
        int left = queryRow(idx * 2, l, mid, k, maxRow);
        if (left != -1) return left;
        return queryRow(idx * 2 + 1, mid + 1, r, k, maxRow);
    }

    public int[] gather(int k, int maxRow) {
        int row = queryRow(1, 0, n - 1, k, maxRow);
        if (row == -1 || next[row] + k > m) return new int[0];
        int start = (int) next[row];
        next[row] += k;
        seats[row] -= k;
        update(1, 0, n - 1, row, seats[row]);
        return new int[]{row, start};
    }

    public boolean scatter(int k, int maxRow) {
        if (querySum(1, 0, n - 1, 0, maxRow) < k) return false;
        int row = 0;
        while (k > 0) {
            row = findNextRow(1, 0, n - 1, row, maxRow);
            long take = Math.min(seats[row], k);
            seats[row] -= take;
            next[row] += take;
            k -= take;
            update(1, 0, n - 1, row, seats[row]);
            row++;
        }
        return true;
    }

    private int findNextRow(int idx, int l, int r, int start, int maxRow) {
        if (r < start || l > maxRow || treeSum[idx] == 0) return -1;
        if (l == r) return l;
        int mid = (l + r) / 2;
        int left = findNextRow(idx * 2, l, mid, start, maxRow);
        if (left != -1) return left;
        return findNextRow(idx * 2 + 1, mid + 1, r, start, maxRow);
    }
}

/**
 * Your BookMyShow object will be instantiated and called as such:
 * BookMyShow obj = new BookMyShow(n, m);
 * int[] param_1 = obj.gather(k,maxRow);
 * boolean param_2 = obj.scatter(k,maxRow);
 */