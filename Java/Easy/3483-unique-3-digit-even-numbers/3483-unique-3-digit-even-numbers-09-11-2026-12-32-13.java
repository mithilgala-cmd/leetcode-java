class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) freq[d]++;
        
        int count = 0;
        for (int num = 100; num <= 999; num += 2) {
            int[] need = new int[10];
            int temp = num;
            for (int i = 0; i < 3; i++) {
                int d = temp % 10;
                need[d]++;
                temp /= 10;
            }
            boolean ok = true;
            for (int d = 0; d < 10; d++) {
                if (need[d] > freq[d]) {
                    ok = false;
                    break;
                }
            }
            if (ok) count++;
        }
        return count;
    }
}