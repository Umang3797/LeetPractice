class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    
    private void helper(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> list) {
        
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1])
                continue;

            if (arr[i] > target)
                break;

            list.add(arr[i]);
            helper(i + 1, arr, target - arr[i], ans, list);
            list.remove(list.size() - 1);
        }
    }
}