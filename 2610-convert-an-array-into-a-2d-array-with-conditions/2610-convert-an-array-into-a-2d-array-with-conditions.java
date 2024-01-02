class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        
        List<List<Integer>> res = new ArrayList();
        List<Integer> list = new ArrayList();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while(true){
            boolean t = false;
            list = new ArrayList();

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getValue()>0){
                    list.add(entry.getKey());
                    t=true;
                    
                    map.put(entry.getKey(),entry.getValue()-1);
                }
                
            }
            if(t==false){
                break;
            }
            res.add(list);
        }
        
        return res;
        
    }
}