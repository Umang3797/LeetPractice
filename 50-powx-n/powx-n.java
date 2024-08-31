class Solution {
    public double myPow(double x, int n) {
        
        double result = 1.0;
        long m = Math.abs((long) n); // Convert n to long to handle Integer.MIN

        while (m > 0) {
            if (m % 2 == 1) {
                result *= x;
            }
            x *= x;
            m /= 2;
        }

        return (n < 0) ? 1 / result : result;
        
//         double ans=1.0;
//         double power=n;
//         if(n<0)
//             n=n*-1;
        
//         while(n>0){
//             if(n%2==0){
//                 x=x*x;
//                 n=n/2;
//             }else{
//                 ans=ans*x;
//                 n=n-1;
//             }
//         }
//         if(power<0)
//             ans=1/ans;
        
//         return ans;
    }
}