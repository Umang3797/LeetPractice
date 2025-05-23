class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if(words==null || words.length==0)
            return new ArrayList();
        
        Set<String> set = new HashSet();
        List<String> ans = new ArrayList();        
        Map<String, Boolean> memo = new HashMap<>();

        
        for(String s : words)
            set.add(s);
        
        for(String s : words) {
            if(isConcat(s, set, memo)) {
                ans.add(s);
            }
        }
        return ans;
    }
    private boolean isConcat(String s, Set<String> set,Map<String, Boolean> memo){
        if (memo.containsKey(s)) 
            return memo.get(s);
        
        int n=s.length();
        for(int i=1;i<n;i++){
            String suffix = s.substring(i);
            if(set.contains(s.substring(0,i)) && (set.contains(suffix) || isConcat(suffix,set,memo))){
                memo.put(s, true);
                return true;
            }
            
        }
        memo.put(s, false);
        return false;
    }
}