class Solution {
    public int combinationSum4(int[] nums, int target) {
        int arr[] = new int[target+1];
        Arrays.fill(arr,-1);
        arr[0]=1;

        helper(nums,target,arr);
        return arr[target];
    }
    private int helper(int[] nums, int target, int[] arr){
        if(arr[target] >-1){
            return arr[target];
        }
        int res=0;
        for(int i : nums){
            if(i<=target){
                res+=helper(nums, target-i,arr);
            }
        }
        arr[target]=res;
        return arr[target];
    }
}