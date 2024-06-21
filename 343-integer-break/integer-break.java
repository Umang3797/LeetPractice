class Solution {
    public int integerBreak(int n) {

        if (n <= 3) {
            return n - 1;
        }

        int quot = n / 3;
        int rem = n % 3;
        if (rem == 0) {
            return (int)(Math.pow(3, quot));
        } else if (rem == 1) {
            return (int)(Math.pow(3, quot - 1) * 4);
        } else {
            return (int)(Math.pow(3, quot) * 2);
        }

    }
}