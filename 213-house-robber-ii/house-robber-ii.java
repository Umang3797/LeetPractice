class Solution {
    int[] memo;
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0]; // If there's only one house, rob it
        if (n == 2) return Math.max(nums[0], nums[1]); // If there are two houses, rob the richer one
        
        // Compute the maximum amount of money that can be robbed for both scenarios
        return Math.max(robLinear(Arrays.copyOfRange(nums, 0, n - 1)), robLinear(Arrays.copyOfRange(nums, 1, n)));
    }

    private int robLinear(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        int[] memo = new int[n];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < n; i++) {
            memo[i] = Math.max(memo[i - 1], memo[i - 2] + nums[i]);
        }
        
        return memo[n - 1];
    }
}
