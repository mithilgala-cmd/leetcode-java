class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freq = new int[n + 1];
        for (int[] item : items) {
            freq[item[0]]++;
        }

        int[] multCount = new int[n + 1];
        for (int f = 1; f <= n; f++) {
            if (freq[f] == 0) continue;
            for (int m = f; m <= n; m += f) {
                multCount[f] += freq[m];
            }
        }

        int[][] enriched = new int[n][2];
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int f = items[i][0];
            int p = items[i][1];
            enriched[i][0] = p;
            enriched[i][1] = multCount[f] - 1;
            if (p < minPrice) {
                minPrice = p;
            }
        }

        Arrays.sort(enriched, (a, b) -> Integer.compare(a[0], b[0]));

        long rem = budget;
        long totalItems = 0;

        for (int i = 0; i < n; i++) {
            int p = enriched[i][0];
            int gain = enriched[i][1];

            if (p >= minPrice * 2L) {
                break;
            }

            if (gain > 0 && rem >= p) {
                long canBuy = Math.min((long) gain, rem / p);
                totalItems += canBuy * 2;
                rem -= canBuy * p;
            }
        }

        totalItems += rem / minPrice;
        return (int) totalItems;
    }
}
