class Solution {
    public int countBeautifulPairs(int[] nums) {
        int[] freq = new int[10];
        int count = 0;

        for (int num : nums) {
            int last = num % 10;

            for (int d = 1; d <= 9; d++) {
                if (freq[d] > 0 && gcd(d, last) == 1) {
                    count += freq[d];
                }
            }
            int first = getFirstDigit(num);
            freq[first]++;
        }
        return count;
    }

    private int getFirstDigit(int num) {
        while (num >= 10) num /= 10;
        return num;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}