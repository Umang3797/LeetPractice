class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        StringBuilder ans= new StringBuilder("1");
        for(int i=1;i<n;i++){
            ans=rle(ans);
        }
        return ans.toString();
    }
    private StringBuilder rle(StringBuilder s){
        StringBuilder result = new StringBuilder();
        
        // Loop over the input string using a for loop.
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int count = 1;
            
            // Count how many times the current digit is repeated consecutively.
            while ((i + 1) < s.length() && s.charAt(i + 1) == currentChar) {
                count++;
                i++;
            }
            
            // Append the count and the digit to the result.
            result.append(count).append(currentChar);
        }
        
        return result;
    }
}