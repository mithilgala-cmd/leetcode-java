class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        java.util.HashSet<Integer> set1 = new java.util.HashSet<>();
        java.util.HashSet<Integer> result = new java.util.HashSet<>();
        
        for (int num : nums1) {
            set1.add(num);
        }
        
        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num);
            }
        }
        
        int[] res = new int[result.size()];
        int i = 0;
        for (int num : result) {
            res[i++] = num;
        }        
        return res;
    }
}