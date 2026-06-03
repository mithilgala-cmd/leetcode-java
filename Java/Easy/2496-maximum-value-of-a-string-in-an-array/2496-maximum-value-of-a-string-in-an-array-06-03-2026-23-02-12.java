class Solution {
    public int maximumValue(String[] strs) {
        int max = 0;

        for (String s : strs) {
            boolean isNumber = true;

            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c)) {
                    isNumber = false;
                    break;
                }
            }

            if (isNumber) {
                max = Math.max(max, Integer.parseInt(s));
            } else {
                max = Math.max(max, s.length());
            }
        }
        return max;
    }
}