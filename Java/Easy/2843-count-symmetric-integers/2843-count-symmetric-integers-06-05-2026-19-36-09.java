class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for (int num = low; num <= high; num++) {
            String s = String.valueOf(num);

            if (s.length() % 2 != 0) continue;

            int n = s.length();
            int half = n / 2;

            int sum1 = 0, sum2 = 0;

            for (int i = 0; i < half; i++) {
                sum1 += s.charAt(i) - '0';
            }

            for (int i = half; i < n; i++) {
                sum2 += s.charAt(i) - '0';
            }

            if (sum1 == sum2) count++;
        }
        return count;
    }
}