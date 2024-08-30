class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        
        // This map will store how many times a certain sum occurred
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // Initialize to handle the case where subarray starts from index 0
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            // If (sum - k) exists in the map, that means there is a subarray that sums up to k
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            
            // Add the current sum to the map (or update its frequency if already present)
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}
