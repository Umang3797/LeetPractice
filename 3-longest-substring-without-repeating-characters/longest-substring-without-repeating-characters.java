class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet();
        int left=0;
        int maxLength=0;
        
        for(int right=0;right<s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;
        
        
        
        
        
        
        
        
        // Map<Character, Integer> map = new HashMap<>();
        // int i = 0;
        // int j = 0;
        // int max = 0;
        // while(j < s.length()){
        //     map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
        //     if(map.size() == j - i + 1){
        //         max = Math.max(max, j - i + 1);
        //         j++;
        //     }
        //     else if(map.size() < j - i + 1){
        //         while(map.size() < j - i + 1){
        //             map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
        //             if(map.get(s.charAt(i)) == 0) 
        //                 map.remove(s.charAt(i));
        //             i++;
        //         }
        //         j++;
        //     }
        // }
        // return max;
    }
}