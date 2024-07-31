class Solution {
    public int numTrees(int n) {
        //catalan number
        //f(i,n)
        //G(n) = f(1,3)     +       f(2,3)      +       f(3,3)
       //      = G(0) G(2)  +   G(1)  G(1)      +  G(2)  G(0)
        // F(i,n) = G(i-1) * G(n-i)
        //G(n) = the summation from 1 to n of F(i, n)

        
        int t[] = new int[n+1];
        t[0]=1;
        t[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                t[i] = t[i] + (t[j] * t[i-j-1]);
            }
        }
        
        return t[n];
    }
}