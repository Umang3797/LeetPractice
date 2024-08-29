class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> allIp = new ArrayList();
        int path[] = new int[4];
        helper(allIp, s, 0, path, 0);
        return allIp;
    }
    private void helper(List<String> allIp, String s, int index, int path[], int segment){
        //base case
        if(segment==4 && index==s.length()){
            allIp.add(path[0]+"."+path[1]+"."+path[2]+"."+path[3]);
        }
        if(segment==4 || index==s.length()) return;
        
        for(int len=1;len<=3 && len+index<=s.length();len++){
            String snapshot = s.substring(index,len+index);
            int value=Integer.parseInt(snapshot);
            if(value>255 || (len>=2 && s.charAt(index)=='0'))
                break;
            
            path[segment]=value;
            helper(allIp,s,index+len,path,segment+1);
            path[segment]=-1;
        }
        
    }
}