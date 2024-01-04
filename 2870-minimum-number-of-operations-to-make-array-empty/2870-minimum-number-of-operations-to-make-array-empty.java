class Solution {
    public int minOperations(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        int count=0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        int t=entry.getValue();
        while(t!=0){
            if(t%3==0){
                count+=t/3;
                t=0;
            }else if(t%2==0){
                count++;
                t-=2;
            }
            else if(t>3){
                t=t-3;
                count++;
            }else{
                return -1;
            }
                
        }
            
        }
        return count;
    }
}