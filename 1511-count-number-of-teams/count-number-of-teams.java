class Solution {
    public int numTeams(int[] rating) {
        int n=rating.length;
        if(n==3 && rating[1]<rating[0] && rating[1]<rating[2]){
            return 0;
        }
        int ans=0;

        for(int i=0;i<=n-3;i++){
            for(int j=i+1;j<=n-2;j++){
                for(int k=j+1;k<=n-1;k++){
                    if((rating[i]<rating[j] && rating[j]<rating[k]) || 
                    (rating[i] > rating[j] && rating[j]>rating[k])){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}