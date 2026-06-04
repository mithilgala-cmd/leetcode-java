class Solution {
    public int distMoney(int money, int children) {
        if (money < children) return -1;

        money -= children;

        int res = 0;

        while (money >= 7 && children > 0) {
            money -= 7;
            res++;
            children--;
        }

        if (children == 0 && money > 0) res--;
        if (children == 1 && money == 3) res--;

        return res;
    }
}