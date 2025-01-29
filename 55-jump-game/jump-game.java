class Solution {
    public boolean canJump(int[] nums) {
        int finalposition=nums.length-1;

        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]+i>=finalposition){
                finalposition=i;
            }
        }

        return finalposition==0;
    }
}