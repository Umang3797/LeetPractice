class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        
        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
          count.put(n, count.getOrDefault(n, 0) + 1);
        }
        
        Queue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> count.get(n2) - count.get(n1));
        
        for (int n : count.keySet()) {
            maxHeap.add(n);
        }
        
        int[] top = new int[k];
        for (int i = 0; i < k; ++i) {
            top[i] = maxHeap.poll();
        }
        return top;

    }
}