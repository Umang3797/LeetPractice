class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int temp_g=0;
        for(int g:gas){
            temp_g+=g;
        }
        int temp_cost=0;
        for(int c: cost){
            temp_cost+=c;
        }
        if(temp_g<temp_cost){
            return -1;
        }
        
        int remaining_fuel=0;
        int n=gas.length;
        int ans=0;
        for(int i=0;i<n;i++){
            remaining_fuel+=gas[i]-cost[i];
            if(remaining_fuel<0){
                ans=i+1;
                remaining_fuel=0;
            }
        }
        return ans;
    }
}