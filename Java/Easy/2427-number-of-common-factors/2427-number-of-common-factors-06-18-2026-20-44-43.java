class Solution {
    public int commonFactors(int a, int b) {
        int gcd = gcd(a, b);
        int count = 0;
        for (int i = 1; i <= gcd; i++) {
            if (a % i == 0 && b % i == 0) count++;
        }
        return count;
    }

    private int gcd(int x, int y) {
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}