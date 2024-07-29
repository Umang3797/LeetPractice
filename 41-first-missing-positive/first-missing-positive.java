class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums==null || nums.length==0){
            return 1;
        }
        int n=nums.length;
        int containsOne=0;

        //step 1
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                containsOne=1;
            }
            else if(nums[i]<=0 || nums[i]>n){
                nums[i]=1;
            }
        }
        if(containsOne==0){
            return 1;
        }

        //step 2
        for(int i=0;i<n;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index] = nums[index]*-1;
            }
        }

        //step 3
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                return i+1;
            }
        }

        return n+1;

    }
}