class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length()==1){
            return 1;
        }
        String[] words = s.trim().split("\\s+");
        return words[words.length-1].length();
    }
}