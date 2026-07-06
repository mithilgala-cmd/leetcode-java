class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int total = 0;
        
        for (int bit = 0; bit < 32; bit++) {
            int countOnes = 0;
            for (int num : nums) {
                if ((num >> bit & 1) == 1) {
                    countOnes++;
                }
            }
            int countZeros = n - countOnes;
            total += countOnes * countZeros;
        }        
        return total;
    }
}