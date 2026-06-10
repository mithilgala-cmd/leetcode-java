class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            stack.push(c);
            if (stack.size() >= 2) {
                char second = stack.pop();
                char first = stack.pop();
                String pair = "" + first + second;
                if (pair.equals("AB") || pair.equals("CD")) {
                    continue;
                } else {
                    stack.push(first);
                    stack.push(second);
                }
            }
        }        
        return stack.size();
    }
}