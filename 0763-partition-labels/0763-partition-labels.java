class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList();
        int c[] = new int[26];
        
        for(int i=0;i<s.length();i++){
            c[s.charAt(i)-'a']=i;
        }
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            end=Math.max(end,c[s.charAt(i)-'a']);
            if(i==end){
                list.add(end-start+1);
                start=end+1;
            }
        }
        return list;
    }
}