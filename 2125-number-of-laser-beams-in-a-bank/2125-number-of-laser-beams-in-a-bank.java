class Solution {
    public int numberOfBeams(String[] bank) {
        
        List<Integer> list = new ArrayList();
        
        for(int i=0;i<bank.length;i++){
            int count=0;
            char[] c = bank[i].toCharArray();
            for(char ch : c){
                if(ch=='1')
                    count++;
            }
            if(count>0){
                list.add(count);
            }
        }
        
        
        int res=0;
        for(int i=0;i<list.size()-1;i++){
            res += list.get(i)*list.get(i+1);
        }
        return res;
        
        
        
        
//         int res=0;
//         int i=0;
//         int j=0;
//         int counti=0;
//         int countj=0;

//         for(i=0;i<bank.length;i++){
//             char[] c = bank[i].toCharArray();
//             for(char ch : c){
//                 if(ch=='1')
//                     counti++;
//             }
            
//             for(j=i+1;j<bank.length;j++){
//                 char[] cj = bank[j].toCharArray();
//                 for(char ch : cj){
//                     if(ch=='1'){
//                         countj++;
                        
//                     }
//                 }
//                 if(countj>0){
//                     break;
//                 }
//             }
//             res+=counti*countj;
//             i=j-1;
            
//         }
//         return res;
    }
}