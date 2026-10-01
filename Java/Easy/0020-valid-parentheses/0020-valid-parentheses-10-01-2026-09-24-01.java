class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack[top++] = ')';
            } else if (c == '{') {
                stack[top++] = '}';
            } else if (c == '[') {
                stack[top++] = ']';
            } else if (top == 0 || stack[--top] != c) {
                return false;
            }
        }        
        return top == 0;
    }
}