class Solution {
    public int minChanges(String s) {
        char ch[] = s.toCharArray();
        
//         int count1=0;
//         int count0=0;
//         int ans=0;
//         for(char c : ch){
//             if(c=='0')
//                 count0++;
//             else 
//                 count1++;
//         }
        
//         ans = count1<count0 ? count1 : count0;
        
        int i=0;
        int j=1;
        int count=0;
        while(i<ch.length && j<ch.length){
            if(ch[i]!=ch[j]){
                count++;
                // ans=Math.min(ans,count);
            }
            i+=2;
            j+=2;
        }
        
        return count;
        
    }
}