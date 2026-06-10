class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int rem = n % 7;

        int totalWeeks = weeks * 28 + (weeks * (weeks - 1) / 2) * 7;

        int totalRem = 0;
        for (int i = 1; i <= rem; i++) {
            totalRem += weeks + i;
        }
        return totalWeeks + totalRem;
    }
}