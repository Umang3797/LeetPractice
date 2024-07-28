class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0)
            return "";
        
        int left=0;
        int right=0;
        for(int i=0;i<s.length();i++){
            int len1 = helper(s,i,i);
            int len2 = helper(s,i,i+1);
            int len=Math.max(len1,len2);
            if(len>right-left){
                left=i-((len-1)/2);
                right=i+(len/2);
            }
        }
        return s.substring(left,right+1);
    }
    private int helper(String s, int start, int end){
        
        if(s==null || start>end)
            return 0;
        
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        
        return end-start-1;
    }
}