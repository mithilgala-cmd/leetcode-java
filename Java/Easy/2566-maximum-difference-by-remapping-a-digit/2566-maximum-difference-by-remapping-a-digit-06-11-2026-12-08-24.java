class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        char[] arr = s.toCharArray();
        
        char targetMax = ' ';
        for (char c : arr) {
            if (c != '9') {
                targetMax = c;
                break;
            }
        }
        String maxStr = s.replace(targetMax == ' ' ? ' ' : targetMax, '9');
        int maxVal = Integer.parseInt(maxStr);

        char targetMin = arr[0];
        String minStr = s.replace(targetMin, '0');
        int minVal = Integer.parseInt(minStr);

        return maxVal - minVal;
    }
}