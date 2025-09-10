class Solution {
    public int[][] merge(int[][] intervals) {
        // if(intervals.length<=1)
        //     return intervals;
        // Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // List<int[]> list = new ArrayList();
        // int[] current_interval= intervals[0];
        // list.add(current_interval);
        
        // for(int[] interval : intervals){
        //     int current_begin = current_interval[0];
        //     int current_end = current_interval[1];
        //     int next_begin = interval[0];
        //     int next_end = interval[1];
            
        //     if(current_end>=next_begin){
        //         current_interval[1] = Math.max(current_end,next_end);
        //     }else{
        //         current_interval=interval;
        //         list.add(current_interval);
        //     }
        // }
        // return list.toArray(new int[list.size()][]);



        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] last = intervals[0];
        merged.add(last);

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] <= last[1]) {
                // overlap → extend the end
                last[1] = Math.max(last[1], curr[1]);
            } else {
                // no overlap → start a new interval
                last = curr;
                merged.add(last);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}