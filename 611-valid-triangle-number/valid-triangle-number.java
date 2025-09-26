class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums); // Sort nondecreasing to leverage triangle inequality
        int n = nums.length;
        int count = 0;

        // Fix the largest side at index k, then use two pointers on [0..k-1]
        for (int k = n - 1; k >= 2; k--) {
            // If the largest side is zero, no triangles can be formed with it
            if (nums[k] == 0) continue;

            int i = 0;
            int j = k - 1;
            // Count pairs (i, j) such that nums[i] + nums[j] > nums[k]
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    // Since the array is sorted, all indices in [i..j-1] with j also satisfy
                    // nums[idx] + nums[j] > nums[k]. That adds (j - i) triangles at once.
                    count += (j - i);
                    j--; // Try a smaller second side to find more pairs
                } else {
                    i++; // Increase the smaller side to increase the sum
                }
            }
        }
        return count;
    }
}