class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans=0;
        int count=0;
        int j=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count++;
            }
            while(count>1){
                j++;
                if(nums[j]==0) count--;
            }
            int len=i-j;
            if(len>ans) ans=len;
        }
        return ans;
    }
}