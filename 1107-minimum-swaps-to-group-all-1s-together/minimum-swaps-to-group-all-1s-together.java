class Solution {
    public int minSwaps(int[] data) {
        // Step 1: Count the total number of 1's
        int totalOnes = 0;
        for (int num : data) {
            if (num == 1) {
                totalOnes++;
            }
        }
        // If there are no 1's or only one 1, no swaps are needed
        if (totalOnes <= 1) {
            return 0;
        }
        // Step 2: Use a sliding window to find the window with the maximum number of 1's
        int maxOnesInWindow = 0;
        int currentOnes = 0;
        int windowSize = totalOnes;
        
        // Initialize the first window
        for (int i = 0; i < windowSize; i++) {
            if (data[i] == 1) {
                currentOnes++;
            }
        }
        maxOnesInWindow = currentOnes;
        
        for (int i = windowSize; i < data.length; i++) {
            // Add the new element to the window
            if (data[i] == 1) {
                currentOnes++;
            }
            // Remove the element that is going out of the window
            if (data[i - windowSize] == 1) {
                currentOnes--;
            }
            // Update the maximum number of ones found in a window
            maxOnesInWindow = Math.max(maxOnesInWindow, currentOnes);
        }
        // Step 3: The minimum swaps is the number of 0's in the best window (windowSize - maxOnesInWindow)
        return windowSize - maxOnesInWindow;
        
    }
}