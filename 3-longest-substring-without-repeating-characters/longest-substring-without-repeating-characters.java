class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s==null || s.length()==0)
            return 0;
        
        Map<Character, Integer> map= new HashMap<>();
        int start=0, maxLength=0;
        
        // abba
        for(int end=0; end<s.length(); end++) {
            char rightChar = s.charAt(end);
            
            if (map.containsKey(rightChar)) {
                if (map.get(rightChar) >= start) 
                    start = map.get(rightChar) + 1;
            }
            
            maxLength = Math.max(maxLength, end-start+1);
            map.put(rightChar, end);
        }
        
        return maxLength;
    }
}

/*
  
a b c a b c b b
0 1 2 3 4 5 6 7
      e
a-0
b-1
c-2

if (map.containsKey(c)) {
                if (map.get(c) >= start) 
                    start = map.get(c) + 1;
            }

*/