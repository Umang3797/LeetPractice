class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endIdx = 0;
        for(int i=0; i<starts.length; i++) {
            if(starts[i] < ends[endIdx]) {
                rooms++; // all rooms occupied, need to allocate new room
            } else {
                endIdx++;  // just re-use the room that ends previous endIdx
            }
        }
        return rooms;
    }
}

/*
intervals = [[0,30],[5,10],[15,20]]
start=[0,5,15]
end=[30,10,20]

sorting
start=[0,5,15]
end=[10,20,30]

*/