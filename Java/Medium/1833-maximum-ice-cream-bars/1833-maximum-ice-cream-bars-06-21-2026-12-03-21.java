class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = 0;
        for (int c : costs) if (c > max) max = c;
        int[] freq = new int[max + 1];
        for (int c : costs) freq[c]++;
        int count = 0;
        for (int i = 1; i <= max && coins > 0; i++) {
            if (freq[i] > 0) {
                int buy = Math.min(freq[i], coins / i);
                count += buy;
                coins -= buy * i;
            }
        }
        return count;
    }
}