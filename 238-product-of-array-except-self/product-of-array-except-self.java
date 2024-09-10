class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        if(nums==null || nums.length==0)
        return nums;

        int ans[] = new int[n];
        // mid1[0]=1;
        // mid2[n-1]=1;

        for(int i=0;i<n;i++){
            ans[i]=1;
        }
        for(int i=1;i<n;i++){
            ans[i] = ans[i-1]*nums[i-1];
        }

        int right=1;
        for(int i=n-1;i>=0;i--){
            ans[i] = ans[i]*right;
            right=right*nums[i];
        }

        //  for(int i=0;i<n;i++){
        //     ans[i] = mid1[i]*mid2[i];
        // }
        return ans;
    }
}