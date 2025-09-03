class HitCounter {

    private Deque<int[]> dq;
    private int totalHits;

    public HitCounter() {
        dq = new ArrayDeque<>();
        totalHits = 0;
    }
    
    public void hit(int timestamp) {
        // If last entry has the same timestamp, just bump its count
        if (!dq.isEmpty() && dq.peekLast()[0] == timestamp) {
            dq.peekLast()[1]++;
        } else {
            dq.offerLast(new int[]{timestamp, 1});
        }
        totalHits++;
    }
    
    public int getHits(int timestamp) {
        // Drop entries that are >= 300 seconds old
        while (!dq.isEmpty() && timestamp - dq.peekFirst()[0] >= 300) {
            totalHits -= dq.peekFirst()[1];
            dq.pollFirst();
        }
        return totalHits;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */