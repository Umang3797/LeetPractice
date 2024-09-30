class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch =s.charAt(i);
            if(Character.isLetter(ch)||Character.isDigit(ch))
                sb.append(ch);
        }
        s=sb.toString();
        sb.reverse();
        String r=sb.toString();
        if(s.equals(r)) 
            return true;

        return false;
    }
}