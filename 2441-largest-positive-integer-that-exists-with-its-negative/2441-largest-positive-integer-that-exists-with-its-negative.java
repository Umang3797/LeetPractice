class Solution {
    public int findMaxK(int[] nums) {
        int max=-1;
        
        Map<Integer, Integer> map = new HashMap();
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],nums[i]);
            if(map.containsKey(-1*nums[i])){
                int num = Math.abs(map.get(nums[i]));
                if(num>max)
                    max=num;
            }
            
        }
        return max;
    }
}