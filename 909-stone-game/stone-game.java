class Solution {
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        int dp[][] = new int[n+1][n+1];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return helper(piles,dp,0,n-1)>0;
    }
    private int helper(int[] piles, int[][] dp, int i, int j){
        if(i>j)
            return 0;
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        dp[i][j]=Math.max(piles[i]-helper(piles,dp,i+1,j), piles[j]-helper(piles,dp,i,j-1));
        
        return dp[i][j];
    }
}