class Solution {
    public int mirrorFrequency(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        int result = 0;
        Set<Character> visited = new HashSet<>();
        
        for (char c : freq.keySet()) {
            if (visited.contains(c)) continue;
            
            char mirror;
            if (Character.isLetter(c)) {
                mirror = (char)('z' - (c - 'a'));
            } else {
                mirror = (char)('9' - (c - '0'));
            }
            
            int f1 = freq.getOrDefault(c, 0);
            int f2 = freq.getOrDefault(mirror, 0);
            result += Math.abs(f1 - f2);
            
            visited.add(c);
            visited.add(mirror);
        }        
        return result;
    }
}