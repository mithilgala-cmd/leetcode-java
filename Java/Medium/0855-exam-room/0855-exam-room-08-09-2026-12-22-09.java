class ExamRoom {
    private int n;
    private TreeSet<Integer> seats;

    public ExamRoom(int n) {
        this.n = n;
        this.seats = new TreeSet<>();
    }

    public int seat() {
        if (seats.isEmpty()) {
            seats.add(0);
            return 0;
        }
        int prev = -1, bestSeat = 0, maxDist = seats.first();
        for (int s : seats) {
            if (prev != -1) {
                int dist = (s - prev) / 2;
                if (dist > maxDist) {
                    maxDist = dist;
                    bestSeat = prev + dist;
                }
            }
            prev = s;
        }
        if (n - 1 - seats.last() > maxDist) {
            bestSeat = n - 1;
        }
        seats.add(bestSeat);
        return bestSeat;
    }

    public void leave(int p) {
        seats.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */