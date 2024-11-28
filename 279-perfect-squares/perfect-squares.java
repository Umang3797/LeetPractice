class Solution {
    
    public int numSquares(int n) {
        
        int sqrtvalue = (int) Math.sqrt(n);
        
        if(sqrtvalue*sqrtvalue==n)
            return 1;
        
        while(n%4==0)
            n/=4;
        
        if(n%8==7)
            return 4;
        
        for(int i=0;i*i<=n;i++){
            int squareA=i*i;
            int elementB = (int) Math.sqrt(n-squareA);
            
            if(elementB*elementB==n-squareA)
                return 2;
        }
        
        return 3;
        
        
        
    //     int[] memo=new int[n+1];
    //     return rec(n,memo);
    // }
    // private int rec(int n,int memo[]){
    //     if(n<0)
    //         return Integer.MAX_VALUE;
    //     if(n==0)
    //         return 0;
    //     if(memo[n]>0)
    //         return memo[n];
    //     int min=n;
    //     for(int i=1;i*i<=n;i++){
    //         min=Math.min(min,rec(n-(i*i),memo));
    //     }
    //     memo[n]=min+1;
    //     return min+1;
    }
}