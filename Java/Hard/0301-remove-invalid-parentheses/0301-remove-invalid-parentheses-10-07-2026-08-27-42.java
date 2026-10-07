class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        remove(s, result, 0, 0, '(', ')');
        return result;
    }

    private void remove(String s, List<String> result, int lastI, int lastJ, char openParen, char closeParen) {
        int count = 0;
        for (int i = lastI; i < s.length(); i++) {
            if (s.charAt(i) == openParen) count++;
            if (s.charAt(i) == closeParen) count--;
            if (count >= 0) continue;

            for (int j = lastJ; j <= i; j++) {
                if (s.charAt(j) == closeParen && (j == lastJ || s.charAt(j - 1) != closeParen)) {
                    remove(s.substring(0, j) + s.substring(j + 1), result, i, j, openParen, closeParen);
                }
            }
            return;
        }

        String reversed = new StringBuilder(s).reverse().toString();
        if (openParen == '(') {
            remove(reversed, result, 0, 0, ')', '(');
        } else {
            result.add(reversed);
        }
    }
}