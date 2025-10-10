class Solution {
    public int maximumEnergy(int[] energy, int k) {
        //traverse from i=0 to i=energy.length-k

        // for(int i=0;i<energy.length-k;i++){
        //     //at each i, store value in energy[i]
        //     energy[i] = energy[i]+energy[i+k];
        // }
        //this fails

        // traverse from the end to the start
        for (int i=energy.length-k-1;i>=0;i--){
            energy[i]=energy[i]+energy[i+k];
        }

        //another loop to see which value is max among all
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<energy.length;i++){
            ans=Math.max(ans,energy[i]);
        }
        return ans;
    }
}