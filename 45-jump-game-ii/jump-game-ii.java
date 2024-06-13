class Solution {
    public int jump(int[] nums) {
        // return functionJump(0,0, nums);
        
        //optimize
        int n = nums.length;
        int jumps=0;
        int l=0;
        int r=0;
        
        while(r<n-1){
            int farthest=0;
            for(int i=l;i<=r;i++){
                farthest=Math.max(farthest, i+nums[i]);
            }
            l=r+1;
            r=farthest;
            jumps+=1;
            
        }
        return jumps;
    }
    
    
    
    
    
    
    
    
    
    
//     private int functionJump(int index, int jump, int[] nums){
//         if(index>=nums.length-1)
//             return jump;
        
//         int min = Integer.MAX_VALUE;
        
//         for(int i=1;i<=nums[index];i++){
//             min = Math.min(min, functionJump(index+i,jump+1,nums));    
//         }
//         return min;
//     }
}