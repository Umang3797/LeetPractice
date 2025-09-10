class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack();
        //st.push(s.charAt(0));
        for(int i=0;i<s.length();i++){
            if(st.isEmpty())
                st.push(s.charAt(i));
            else if(!st.isEmpty() && st.peek()!=s.charAt(i))
                st.push(s.charAt(i));
            else
                st.pop();

        }
        StringBuilder result= new StringBuilder();
        while(!st.isEmpty()){
            result.append(st.pop().toString());
        }
        return result.reverse().toString();
    }
}