class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1)
            return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // Arrays.sort(intervals, (a, b) -> {
        //     if (a[0] != b[0]) {
        //         return Integer.compare(a[0], b[0]);
        //     } else {
        //         return Integer.compare(a[1], b[1]);
        //     }
        // });
        List<int[]> list = new ArrayList();
        int[] current_interval= intervals[0];
        list.add(current_interval);
        
        for(int[] interval : intervals){
            int current_begin = current_interval[0];
            int current_end = current_interval[1];
            int next_begin = interval[0];
            int next_end = interval[1];
            
            if(current_end>=next_begin){
                current_interval[1] = Math.max(current_end,next_end);
            }else{
                current_interval=interval;
                list.add(current_interval);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}