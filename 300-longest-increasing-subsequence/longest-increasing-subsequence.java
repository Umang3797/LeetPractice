class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length][nums.length];
        return LISHelper(-1, 0, nums,dp);
    }
    
    private static int LISHelper(int prev, int curr, int nums[], int dp[][]){
        if(curr == nums.length) return 0;

        if(prev!=-1 && dp[prev][curr]!=0){
            return dp[prev][curr];
        }
        
        int op1 = 0;
        if(prev == -1 || nums[prev] < nums[curr]){
            op1 =  1 + LISHelper(curr, curr+1,nums, dp);
        }        
        int op2 = LISHelper(prev, curr+1,nums, dp);
       
        if(prev!=-1){
            dp[prev][curr]=Math.max(op1, op2);
        }
        return Math.max(op1, op2);



        // if(nums.length<=1)
        //     return nums.length;
        
        // int dp[] = new int[nums.length];
        // Arrays.fill(dp,1);
        // int ans=-1;
        // for(int i=1;i<nums.length;i++){
        //     for(int j=0;j<i;j++){
        //         if(nums[j]<nums[i])
        //             dp[i] = Math.max(dp[i], dp[j]+1);
        //     }
        //     ans=Math.max(ans,dp[i]);
        // }
        // return ans;
    }
}