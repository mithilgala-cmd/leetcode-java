class Solution {
    public List<String> cellsInRange(String s) {
        List<String> res = new ArrayList<>();

        char c1 = s.charAt(0);
        char c2 = s.charAt(3);
        int r1 = s.charAt(1) - '0';
        int r2 = s.charAt(4) - '0';

        for (char c = c1; c <= c2; c++) {
            for (int r = r1; r <= r2; r++) {
                res.add("" + c + r);
            }
        }
        return res;
    }
}