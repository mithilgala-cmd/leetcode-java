class Solution {
    public boolean canAliceWin(int[] nums) {
        int single = 0, dbl = 0, other = 0;
        for (int num : nums) {
            if (num < 10) single += num;
            else if (num < 100) dbl += num;
            else other += num;
        }
        return single > dbl + other || dbl > single + other;
    }
}