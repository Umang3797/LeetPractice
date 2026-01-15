class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        // Step 1: Sort the tokens to handle them greedily
        Arrays.sort(tokens);
        
        int score = 0;
        int maxScore = 0;
        int left = 0;
        int right = tokens.length - 1;

        // Step 2: Use two pointers to process tokens
        while (left <= right) {
            // Option 1: Face-up (Gain score)
            // If we have enough power, take the smallest token
            if (power >= tokens[left]) {
                power -= tokens[left];
                score++;
                left++;
                // Update the maximum score reached so far
                maxScore = Math.max(maxScore, score);
            } 
            // Option 2: Face-down (Gain power)
            // If we have score and it's worth it to keep going
            else if (score > 0) {
                power += tokens[right];
                score--;
                right--;
            } 
            // Option 3: Stuck
            // We can't gain score OR power, so stop immediately
            else {
                break;
            }
        }
        
        return maxScore;
        
    }
}