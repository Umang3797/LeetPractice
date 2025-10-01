class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalsum=0;
        int totalremaining=0;
        int x=numBottles;


        while(numBottles>=numExchange){
            int quotient=numBottles/numExchange;
            totalsum+=quotient;


            int remainder=numBottles%numExchange;

            numBottles=quotient+remainder;
        }



        return totalsum+x;
    }
}


// sum=numbottles+ 3 +1
// 15/4 = 3
// 15/4 = 3 remaining

// 3+3=6 /4 = 1
// 6/4=2 remaining

// 1+2=3/4