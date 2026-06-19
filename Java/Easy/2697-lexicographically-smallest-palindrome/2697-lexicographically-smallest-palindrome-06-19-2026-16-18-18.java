class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] != arr[j]) {
                char smaller = (char) Math.min(arr[i], arr[j]);
                arr[i] = smaller;
                arr[j] = smaller;
            }
            i++;
            j--;
        }
        return new String(arr);
    }
}