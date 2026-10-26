class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> prefixSet = new HashSet<>();
        
        for (int num : arr1) {
            while (num > 0) {
                prefixSet.add(num);
                num /= 10;
            }
        }
        
        int maxLength = 0;
        
        for (int num : arr2) {
            while (num > 0) {
                if (prefixSet.contains(num)) {
                    maxLength = Math.max(maxLength, String.valueOf(num).length());
                    break;
                }
                num /= 10;
            }
        }        
        return maxLength;
    }
}