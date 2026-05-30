class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder newStr = new StringBuilder();

            for (int i = 0; i < s.length(); i += k) {
                int sum = 0;

                for (int j = i; j < i + k && j < s.length(); j++) {
                    sum += s.charAt(j) - '0';
                }
                newStr.append(sum);
            }
            s = newStr.toString();
        }
        return s;
    }
}