class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        
        // Calculate the total sum of the array elements
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        // If the sum is odd, it's impossible to partition it into two equal subsets
        if (sum % 2 != 0) {
            return false;
        }
        
        // The target sum for each subset
        int target = sum / 2;
        
        // DP array initialization
        Boolean[][] dp = new Boolean[len][target + 1];
        
        // Fill the DP array with null values
        for (Boolean[] row : dp) {
            Arrays.fill(row, null);
        }

        return dphelper(len-1,target,nums,dp);
    }
    private static boolean dphelper(int ind, int target, int[] arr, Boolean dp[][]){
        if (target == 0) {
            return true;
        }
        
        if (ind == 0) {
            return arr[0] == target;
        }
        
        if (dp[ind][target] != null) {
            return dp[ind][target];
        }
        
        boolean notTaken = dphelper(ind - 1, target, arr, dp);
        boolean taken = false;
        if (arr[ind] <= target) {
            taken = dphelper(ind - 1, target - arr[ind], arr, dp);
        }
        
        dp[ind][target] = notTaken || taken;
        return dp[ind][target];
    }
}