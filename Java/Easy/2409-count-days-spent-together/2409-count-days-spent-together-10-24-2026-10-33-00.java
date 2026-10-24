class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int aliceStart = toDayOfYear(arriveAlice, daysInMonth);
        int aliceEnd = toDayOfYear(leaveAlice, daysInMonth);
        int bobStart = toDayOfYear(arriveBob, daysInMonth);
        int bobEnd = toDayOfYear(leaveBob, daysInMonth);

        int overlapStart = Math.max(aliceStart, bobStart);
        int overlapEnd = Math.min(aliceEnd, bobEnd);

        return Math.max(0, overlapEnd - overlapStart + 1);
    }

    private int toDayOfYear(String date, int[] daysInMonth) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int dayOfYear = 0;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += daysInMonth[i];
        }
        dayOfYear += day;

        return dayOfYear;
    }
}