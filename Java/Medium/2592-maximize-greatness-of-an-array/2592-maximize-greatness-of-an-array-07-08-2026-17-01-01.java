class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = 0, n = nums.length, count = 0;
        
        while (i < n && j < n) {
            if (nums[j] > nums[i]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }        
        return count;
    }
}