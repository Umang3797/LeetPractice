class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> list = new ArrayList();
        boolean[] visited = new boolean[nums.length];
        //Set<List<Integer>> set = new HashSet();
        Arrays.sort(nums);
        helper(res,list,nums,visited);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> list, int nums[], boolean[] visited){
        
        if(list.size()==nums.length){
            res.add(new ArrayList(list));
            // set.add(list);
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i]=true;
            list.add(nums[i]);
            helper(res,list,nums,visited);
            list.remove(list.size()-1);
            visited[i]=false;
        }
    }
}