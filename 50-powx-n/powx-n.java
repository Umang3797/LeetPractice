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
        
    }
}