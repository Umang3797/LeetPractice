class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        
        int ans = 2;  // Start with 2 because the first two elements are always valid
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[ans - 2]) {  
                nums[ans] = nums[i];// Place the current element at next valid position
                ans++;
            }
        }
        return ans;
    }
}