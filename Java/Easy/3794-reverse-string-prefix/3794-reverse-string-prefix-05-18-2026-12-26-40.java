class Solution {
    public String reversePrefix(String s, int k) {
        char[] arr = s.toCharArray();
        
        int l = 0, r = k - 1;
        
        while (l < r) {
            char t = arr[l];
            arr[l++] = arr[r];
            arr[r--] = t;
        }
        
        return new String(arr);
    }
}