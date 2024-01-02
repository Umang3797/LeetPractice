class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        while (true) {
            // n = numSquareSum(n);
            int squareSum = 0;
        while (n!= 0){
            squareSum += (n % 10) * (n % 10);
            n /= 10;
        }
            n = squareSum;
            if (squareSum == 1)
                return true;
            if (set.contains(squareSum))
                return false;
            set.add(squareSum);
        }
    }
    private int numSquareSum(int n){
        int squareSum = 0;
        while (n!= 0){
            squareSum += (n % 10) * (n % 10);
            n /= 10;
        }
        return squareSum;
    }
}