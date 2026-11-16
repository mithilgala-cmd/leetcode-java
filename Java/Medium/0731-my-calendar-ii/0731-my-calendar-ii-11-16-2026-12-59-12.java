class MyCalendarTwo {
    private List<int[]> bookings;
    private List<int[]> overlaps;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for (int[] o : overlaps) {
            if (Math.max(startTime, o[0]) < Math.min(endTime, o[1])) {
                return false;
            }
        }
        
        for (int[] b : bookings) {
            int overlapStart = Math.max(startTime, b[0]);
            int overlapEnd = Math.min(endTime, b[1]);
            if (overlapStart < overlapEnd) {
                overlaps.add(new int[]{overlapStart, overlapEnd});
            }
        }        
        bookings.add(new int[]{startTime, endTime});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */