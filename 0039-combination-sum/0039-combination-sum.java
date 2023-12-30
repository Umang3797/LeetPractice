class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> list = new ArrayList<Integer>();
        helper(0,target, candidates, list, res);
        return res;
    }
    private void helper(int index, int target, int[] candidates, List<Integer> list, List<List<Integer>> res){
        if(index==candidates.length){
            if(target==0){
                res.add(new ArrayList<Integer>(list));  
            }
            return;
        }
        //pick up
        if(candidates[index]<=target){
            list.add(candidates[index]);
            helper(index, target-candidates[index],candidates,list,res);
            list.remove(list.size()-1);
        }

        //not pick up
        helper(index+1, target,candidates,list,res);


    }
}