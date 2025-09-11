class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // If k <= 1, no positive product can be strictly less than k
        if (k <= 1) return 0;

        int left = 0;
        long prod = 1;         // running product of the current window [left..right]
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            // Shrink window from the left while product is >= k
            while (prod >= k && left <= right) {
                prod /= nums[left];
                left++;
            }
            count += (right - left + 1);
        }

        return count;
    }
}