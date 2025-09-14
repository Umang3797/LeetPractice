class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        Map<Integer, Integer> count = new HashMap();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        // Queue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> count.get(n2) - count.get(n1));
        // Queue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> 
        // Integer.compare(count.get(n2), count.get(n1)));

        //min heap
        Queue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> 
        Integer.compare(count.get(n1), count.get(n2)));
        
        for (int n : count.keySet()) {
            minHeap.add(n);
            if(minHeap.size()>k){
                minHeap.poll();
            }
            
        }
        int[] top = new int[k];
        for (int i = 0; i < k; ++i) {
            top[i] = minHeap.poll();
        }

        // for (int n : count.keySet()) {
        //     maxHeap.add(n);
        // }
        // int[] top = new int[k];
        // for (int i = 0; i < k; ++i) {
        //     top[i] = maxHeap.poll();
        // }
        return top;
    }
}