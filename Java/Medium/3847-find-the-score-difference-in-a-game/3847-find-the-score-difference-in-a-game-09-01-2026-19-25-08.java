class Solution {
    public int scoreDifference(int[] nums) {
        int score1 = 0, score2 = 0;
        int active = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) active ^= 1;
            if ((i + 1) % 6 == 0) active ^= 1;
            if (active == 0) score1 += nums[i];
            else score2 += nums[i];
        }
        return score1 - score2;
    }
}