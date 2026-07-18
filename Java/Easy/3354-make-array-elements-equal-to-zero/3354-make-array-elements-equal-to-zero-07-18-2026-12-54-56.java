class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (simulate(nums.clone(), i, 1)) count++;
                if (simulate(nums.clone(), i, -1)) count++;
            }
        }
        return count;
    }
    private boolean simulate(int[] arr, int curr, int dir) {
        int n = arr.length;
        while (curr >= 0 && curr < n) {
            if (arr[curr] == 0) {
                curr += dir;
            } else {
                arr[curr]--;
                dir = -dir;
                curr += dir;
            }
        }
        for (int x : arr) if (x != 0) return false;
        return true;
    }
}