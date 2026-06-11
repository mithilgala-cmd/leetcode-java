class Solution {
    public int findNonMinOrMax(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        for (int num : nums) {
            if (num != min && num != max) return num;
        }
        return -1;
    }
}