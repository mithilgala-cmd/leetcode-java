class Solution {
    public int numberOfSpecialChars(String word) {
        java.util.HashSet<Character> lower = new java.util.HashSet<>();
        java.util.HashSet<Character> upper = new java.util.HashSet<>();
        
        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lower.add(ch);
            } else {
                upper.add(Character.toLowerCase(ch));
            }
        }
        
        int count = 0;
        
        for (char ch : lower) {
            if (upper.contains(ch)) {
                count++;
            }
        }        
        return count;
    }
}