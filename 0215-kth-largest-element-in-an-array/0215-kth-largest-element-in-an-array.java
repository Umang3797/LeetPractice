class Solution {
    public int findKthLargest(int[] nums, int k) {
        
         Queue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2-n1);
        
        for (int n : nums) {
            maxHeap.add(n);
        }
        
        for (int i = 1; i < k; ++i) {
            maxHeap.poll();
        }
        return maxHeap.poll();
    }
}