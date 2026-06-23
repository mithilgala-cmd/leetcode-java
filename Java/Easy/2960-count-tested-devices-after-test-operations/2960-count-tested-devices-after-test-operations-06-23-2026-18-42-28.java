class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int tested = 0, decrease = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            if (batteryPercentages[i] - decrease > 0) {
                tested++;
                decrease++;
            }
        }
        return tested;
    }
}