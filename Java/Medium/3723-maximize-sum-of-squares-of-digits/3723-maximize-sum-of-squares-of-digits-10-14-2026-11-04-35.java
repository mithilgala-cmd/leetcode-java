class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9L * num) {
            return "";
        }

        char[] res = new char[num];
        int remainingSum = sum;

        for (int i = 0; i < num; i++) {
            int digit = Math.min(9, remainingSum);
            res[i] = (char) ('0' + digit);
            remainingSum -= digit;
        }
        return new String(res);
    }
}