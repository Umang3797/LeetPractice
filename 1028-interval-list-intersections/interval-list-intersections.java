class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList==null || firstList.length==0 ||
          secondList==null || secondList.length==0){
            return new int[0][0];  
        }
        
        List<int[]> list = new ArrayList();
        int i=0;
        int j=0;
        while(i<firstList.length && j<secondList.length){
            int max=Math.max(firstList[i][0],secondList[j][0]);            
            int min=Math.min(firstList[i][1],secondList[j][1]);
            
            if(max<=min){
                list.add(new int[]{max,min});
            }
            if(firstList[i][1]<secondList[j][1])
                i++;
            else
                j++;

        }
        
        
        int[][] res=new int[list.size()][2];
        
        for(int x=0;x<list.size();x++){
            res[x] = list.get(x);
        }
        
        return res;
        
    }
}