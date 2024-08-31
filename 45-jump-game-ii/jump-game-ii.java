class Solution {
    public int jump(int[] nums) {
        int totaljumps=0;
        int destination=nums.length-1;
        int coverage=0;
        int lastJumpIndex=0;
        
        if(nums.length==1)
            return 0;
        
        for(int i=0;i<nums.length;i++){
            coverage = Math.max(coverage,i+nums[i]);
            
            if(i==lastJumpIndex){
                lastJumpIndex=coverage;
                totaljumps++;
                
                if(coverage>=destination)
                return totaljumps;
            }   
        }
        return totaljumps;
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