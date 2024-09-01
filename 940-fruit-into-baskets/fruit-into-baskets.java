class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> map = new HashMap();
        int left=0;
        
        int ans=0;
        
        
        for(int right=0;right<fruits.length;right++){
            map.put(fruits[right], map.getOrDefault(fruits[right],0)+1);
            
            while(map.size()>2){
                int fruitCount=map.get(fruits[left]);
                if(fruitCount==1){
                    map.remove(fruits[left]);
                }else{
                    map.put(fruits[left],fruitCount-1);
                }
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        
        return ans;
    }
}