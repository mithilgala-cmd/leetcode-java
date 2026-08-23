class Solution {
    public boolean sumGame(String num) {
        int n = num.length(), half = n / 2;
        int leftSum = 0, rightSum = 0, leftQ = 0, rightQ = 0;
        for (int i = 0; i < half; i++) {
            char c = num.charAt(i);
            if (c == '?') leftQ++;
            else leftSum += c - '0';
        }
        for (int i = half; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') rightQ++;
            else rightSum += c - '0';
        }
        int diff = leftSum - rightSum;
        int qDiff = rightQ - leftQ;
        return (diff * 2 != 9 * qDiff);
    }
}