class Solution {
    public int longestPalindromeSubseq(String S) {
        String R = new StringBuilder(S).reverse().toString();
        // dp[i][j] will store the length of the longest
        // palindromic subsequence for the substring
        // starting at index i and ending at index j
        int dp[][] = new int[S.length() + 1][R.length() + 1];
        
        // Filling up DP table based on conditions discussed
        // in above approach
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= R.length(); j++) {
                if (S.charAt(i - 1) == R.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1],dp[i - 1][j]);
            }
        }
        
        return dp[S.length()][R.length()];
        
    }
}