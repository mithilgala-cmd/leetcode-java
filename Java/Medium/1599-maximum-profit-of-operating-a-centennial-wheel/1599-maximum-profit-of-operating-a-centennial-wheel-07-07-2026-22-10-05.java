class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int waiting = 0, boarded = 0;
        int rotations = 0, maxProfit = 0, bestRotation = -1;
        
        for (int i = 0; i < customers.length || waiting > 0; i++) {
            if (i < customers.length) waiting += customers[i];
            int board = Math.min(4, waiting);
            waiting -= board;
            boarded += board;
            rotations++;
            
            int profit = boarded * boardingCost - rotations * runningCost;
            if (profit > maxProfit) {
                maxProfit = profit;
                bestRotation = rotations;
            }
        }        
        return maxProfit > 0 ? bestRotation : -1;
    }
}