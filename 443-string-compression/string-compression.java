class Solution {
    public int compress(char[] chars) {
        if(chars==null || chars.length==0)
            return 0;
        
        if(chars.length==1)
            return 1;
        
        int count=0;
        int j=0;
        for(int i=0;i<chars.length;i++){
            count=1;
            while(i<chars.length-1 && chars[i]==chars[i+1]){
                count++;
                i++;
            }
            chars[j]=chars[i];
            j++;
            
            if(count>1){
                String countStr = Integer.toString(count);
                for (char c : countStr.toCharArray()) {
                    chars[j] = c;
                    j++;
                }
            }
            
        }
        return j;
    }
}