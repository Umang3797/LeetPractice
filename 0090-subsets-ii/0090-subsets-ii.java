class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(nums);
        getsubsets( 0, nums, ds, ans);
        return ans;
    }
    public void getsubsets(int idx, int nums[], List<Integer> ds,  List<List<Integer>> ans) {
        ans.add(new ArrayList(ds));
        
        for (int i=idx; i<nums.length; i++) {
            if (i!=idx && nums[i]==nums[i-1])
                continue;
            ds.add(nums[i]);
            getsubsets(i+1 , nums , ds, ans);
            ds.remove(ds.size()-1);

            
        }
    }
    
}