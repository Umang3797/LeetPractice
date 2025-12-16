class Solution {
    public int minDistance(String word1, String word2) {
        /**
        start i=0
        if the letter is same- proceed i
        if letter is different-replace(increase ans)
        if word 1 is over, remaining letter of word 2 is ans++ (like insert)
        if word 1 is remaninig, words 2 is over, extra from word 1 is ans++(like delete)

        
         */

        int m = word1.length();
        int n = word2.length();
        
        // dp[i][j] = edit distance between word1[0..i-1] and word2[0..j-1]
        int[][] dp = new int[m + 1][n + 1];

        // Base case: convert to empty string (delete all)
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        // Base case: convert from empty string (insert all)
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Characters match - no operation needed
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    // Take minimum of three operations:
                    // 1. Delete: dp[i-1][j]   (remove last char of word1)
                    // 2. Insert: dp[i][j-1]   (add last char of word2 to word1)
                    // 3. Replace: dp[i-1][j-1] (replace word1's char to match word2)
                    dp[i][j] = 1 + Math.min(
                        Math.min(dp[i - 1][j],    // delete
                                dp[i][j - 1]),    // insert
                                dp[i - 1][j - 1]  // replace
                    );
                }
            }
        }
        return dp[m][n];
    }
}