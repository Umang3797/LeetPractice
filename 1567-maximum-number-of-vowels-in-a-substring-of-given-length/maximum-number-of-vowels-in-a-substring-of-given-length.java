class Solution {
    public int maxVowels(String s, int k) {

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int max = 0;
        int count = 0;
        int left=0;
        for (int right = 0; right <s.length(); right++) {
            // New character enters window
            if (vowels.contains(s.charAt(right))) {
                count++;
            }
            // Shrink window if size > k
            if (right - left + 1 > k) {
                if (vowels.contains(s.charAt(left))) {
                    count--;
                }
                left++; // Always move left to maintain window size
            }
            max=Math.max(max,count);
        }
        return max;


        // Set<Character> set = new HashSet();
        // set.add('a');
        // set.add('e');
        // set.add('i');
        // set.add('o');
        // set.add('u');
        
        // int ans=0;

        // int left=0;
        // int right=left+k;
        // while(right<=s.length()){
        //     int max=0;
        //     String vowelsinSubstring=s.substring(left,right);
        //     for(char c: vowelsinSubstring.toCharArray()){
        //         if(set.contains(c)){
        //             max++;
        //             ans=Math.max(ans,max);
        //         }
        //     }
        //     left++;
        //     right++;
        // }


        // return ans;
    }
}