class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        java.util.List<Integer> list = new java.util.ArrayList<>();
        
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }        
        return res;
    }
}