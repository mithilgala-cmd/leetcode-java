class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans = 0;
        for (int[] customer : accounts) {
            int sum = 0;
            for (int money : customer) sum += money;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}