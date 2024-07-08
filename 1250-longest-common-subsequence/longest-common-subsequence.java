class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        
        int memo[][] = new int[n][m];
        for (int rows[] : memo)
            Arrays.fill(rows, -1);
        
        return dp(n-1,m-1,text1,text2,memo);
    }
    private int dp(int index1, int index2, String text1, String text2, int[][] memo){
        
        if(index1<0 || index2<0)
            return 0;
        
        if(memo[index1][index2]!=-1)
            return memo[index1][index2];
        
        if(text1.charAt(index1)==text2.charAt(index2)){
            return memo[index1][index2]= 1 + dp(index1-1,index2-1,text1,text2,memo);
        }
        
        return memo[index1][index2] = Math.max(dp(index1-1,index2,text1,text2,memo),dp(index1,index2-1,text1,text2,memo));
    }
}