class Solution {
    public int minCost(String colors, int[] neededTime) {
        int res=0;
        int maxSoFar = 0;
        for(int i=0;i<neededTime.length;i++){
            maxSoFar = neededTime[i];
            while(i<neededTime.length-1 && colors.charAt(i)==colors.charAt(i+1)){
                res += Math.min(maxSoFar,neededTime[i+1]);
                maxSoFar = Math.max(maxSoFar,neededTime[i+1]); 
                i++;
            }
        }
        return res;
    }
}