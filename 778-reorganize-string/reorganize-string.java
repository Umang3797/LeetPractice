class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> map = new HashMap();
        for(char c: s.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
        
        Queue<Character> pq = new PriorityQueue((a,b)->map.get(b)-map.get(a));
        pq.addAll(map.keySet());
        
        StringBuilder ans = new StringBuilder();
        
        while(pq.size()>1){
            char current = pq.remove();
            char next = pq.remove();
            ans.append(current);
            ans.append(next);
            map.put(current,map.get(current)-1); 
            map.put(next,map.get(next)-1);
            if(map.get(current)>0)
                pq.add(current);
            if(map.get(next)>0)
                pq.add(next);
        }
        
        if(!pq.isEmpty()){
            char lastchar = pq.remove();
            if(map.get(lastchar)>1){
                return "";
            }
            ans.append(lastchar);
        }
        
        return ans.toString();
        
    }
}