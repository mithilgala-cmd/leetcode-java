class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for (int d = 2; d <= n; d++) {
            for (int num = 1; num < d; num++) {
                if (gcd(num, d) == 1) {
                    res.add(num + "/" + d);
                }
            }
        }
        return res;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}