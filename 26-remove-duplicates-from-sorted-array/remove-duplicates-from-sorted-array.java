class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==1){
            return 1;
        }
        int ans=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[ans - 1]) {  // Compare with the last unique element
                nums[ans] = nums[i];  // Place the unique element in the next position
                ans++;
            }
        }

        return ans;
    }
}