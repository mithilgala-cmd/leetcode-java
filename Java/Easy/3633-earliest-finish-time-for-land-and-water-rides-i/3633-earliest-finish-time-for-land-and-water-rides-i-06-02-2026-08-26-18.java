class Solution {
    public int earliestFinishTime(int[] landStart, int[] landDur,
                                  int[] waterStart, int[] waterDur) {

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < landStart.length; i++) {
            int landEnd = landStart[i] + landDur[i];

            for (int j = 0; j < waterStart.length; j++) {
                int startWater = landEnd > waterStart[j] ? landEnd : waterStart[j];
                int finish = startWater + waterDur[j];

                if (finish < ans) ans = finish;
            }
        }

        for (int i = 0; i < waterStart.length; i++) {
            int waterEnd = waterStart[i] + waterDur[i];

            for (int j = 0; j < landStart.length; j++) {
                int startLand = waterEnd > landStart[j] ? waterEnd : landStart[j];
                int finish = startLand + landDur[j];

                if (finish < ans) ans = finish;
            }
        }
        return ans;
    }
}