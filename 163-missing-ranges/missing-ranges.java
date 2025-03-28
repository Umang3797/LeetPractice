class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length==0){
            list.add(Arrays.asList(lower, upper));
            return list;
        }
        
        if(nums[0]>lower)
            list.add(new ArrayList<>(Arrays.asList(lower, nums[0]-1)));
        
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]+1!=nums[i+1]){
                list.add(new ArrayList<>(Arrays.asList(nums[i]+1,nums[i+1]-1)));
            }
        }
        
        if(nums[nums.length-1]<upper){
            list.add(new ArrayList<>(Arrays.asList(nums[nums.length-1]+1, upper)));
        }
        
        return list;
        
        /*
        
        
        */
    }
}