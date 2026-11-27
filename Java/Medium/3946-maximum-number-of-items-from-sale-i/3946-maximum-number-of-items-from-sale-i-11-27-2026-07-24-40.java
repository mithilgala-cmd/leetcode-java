class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int maxFactor = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
            minPrice = Math.min(minPrice, item[1]);
        }

        int[] freq = new int[maxFactor + 1];
        for (int[] item : items) {
            freq[item[0]]++;
        }

        int[] divCount = new int[maxFactor + 1];
        for (int f = 1; f <= maxFactor; f++) {
            for (int multiple = f; multiple <= maxFactor; multiple += f) {
                divCount[f] += freq[multiple];
            }
        }

        int[] dp = new int[budget + 1];
        for (int c = 1; c <= budget; c++) {
            dp[c] = -1;
        }

        for (int[] item : items) {
            int price = item[1];
            int firstCopyGain = divCount[item[0]];
            for (int c = budget; c >= price; c--) {
                if (dp[c - price] != -1) {
                    dp[c] = Math.max(dp[c], dp[c - price] + firstCopyGain);
                }
            }
        }

        int maxItems = 0;
        for (int c = 0; c <= budget; c++) {
            if (dp[c] != -1) {
                maxItems = Math.max(maxItems, dp[c] + (budget - c) / minPrice);
            }
        }
        return maxItems;
    }
}