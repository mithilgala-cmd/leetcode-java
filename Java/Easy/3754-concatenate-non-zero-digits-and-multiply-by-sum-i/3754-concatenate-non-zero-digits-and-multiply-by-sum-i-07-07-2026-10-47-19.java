class Solution {
    public long sumAndMultiply(int n) {
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        int digitSum = 0;
        
        for (char c : s.toCharArray()) {
            if (c != '0') {
                sb.append(c);
                digitSum += c - '0';
            }
        }
        
        long x = sb.length() == 0 ? 0 : Long.parseLong(sb.toString());
        return x * digitSum;
    }
}