class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder ans = new StringBuilder();
        int i = 0, d = 1;

        while (i < n) {
            char c = s.charAt(i);

            if (c == '(' || c == ')') {
                i = pair[i];
                d = -d;
            } else {
                ans.append(c);
            }
            i += d;
        }
        return ans.toString();
    }
}