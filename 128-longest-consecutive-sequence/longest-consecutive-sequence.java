class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        
        for(int num:nums){
            set.add(num);
        }
        
        int max_sequence=0;
        
        for(int i=0;i<nums.length;i++){
            int current=nums[i];
            int current_seq_length=1;
        
            if(!set.contains(current-1)){
                while(set.contains(current+1)){
                    current+=1;
                    current_seq_length+=1;
                }
                max_sequence=Math.max(max_sequence,current_seq_length);
            }
        }
        return max_sequence;
    }
}