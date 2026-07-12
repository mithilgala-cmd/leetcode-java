class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);

        for (int m = 63; m >= 2; m--) {
            long left = 2, right = (long) Math.pow(num, 1.0 / (m - 1)) + 1;

            while (left <= right) {
                long k = left + (right - left) / 2;

                long sum = 1;
                long cur = 1;

                for (int i = 1; i < m; i++) {
                    if (cur > num / k) {
                        sum = num + 1;
                        break;
                    }
                    cur *= k;
                    sum += cur;

                    if (sum > num) break;
                }

                if (sum == num) return String.valueOf(k);

                if (sum < num) left = k + 1;
                else right = k - 1;
            }
        }
        return String.valueOf(num - 1);
    }
}