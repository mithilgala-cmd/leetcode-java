class Solution {
    public List<Integer> findGoodIntegers(int n) {
        Map<Integer, Integer> count = new HashMap<>();
        int limit = (int)Math.cbrt(n);
        
        for (int a = 1; a <= limit; a++) {
            for (int b = a; b <= limit; b++) {
                long sum = (long)a*a*a + (long)b*b*b;
                if (sum > n) break;
                count.put((int)sum, count.getOrDefault((int)sum, 0) + 1);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int x : count.keySet()) {
            if (count.get(x) >= 2) result.add(x);
        }
        Collections.sort(result);
        return result;
    }
}