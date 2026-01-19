class MyCalendar {

    // TreeMap stores start -> end mappings, sorted by start time
    private TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        // Find the event that starts AT or BEFORE the new event
        // If there's a previous event, check if it overlaps with the new one
        Integer previousStart = calendar.floorKey(start);
        if (previousStart != null && calendar.get(previousStart) > start) {
            return false;
        }

        // Find the event that starts AFTER the new event
        // If there's a next event, check if it overlaps with the new one
        // Overlap occurs if new event's end > next event's start
        Integer nextStart = calendar.ceilingKey(start);
        if (nextStart != null && end > nextStart) {
            return false;
        }

        // No overlaps found, book the event
        calendar.put(start, end);
        return true;
    }

}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */