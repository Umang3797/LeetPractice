class Solution {
    public int scheduleCourse(int[][] courses) {
        if(courses.length==0){
            return 0;
        }
        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)  // Compare second element in descending order
        );
        int sum=0;
        for(int[] i : courses){
            sum+=i[0];
            maxHeap.add(i[0]);
            if(sum>i[1]){
                sum-=maxHeap.peek();
                maxHeap.poll();
            }
        }

        return maxHeap.size();
    }
}