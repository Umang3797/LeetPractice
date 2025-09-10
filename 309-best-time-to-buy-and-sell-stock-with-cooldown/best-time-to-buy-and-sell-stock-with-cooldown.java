class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int hold = -prices[0];  // Day 1: buy at 1 → hold = -1
        int sold = 0;           // nothing sold yet
        int rest = 0;           // nothing resting yet

        // ---- Start loop ----
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];

            int prevHold = hold;
            int prevSold = sold;
            int prevRest = rest;

            // If we hold today:
            // - either we were already holding
            // - or we buy today (so must come from rest)
            hold = Math.max(prevHold, prevRest - price);

            // If we sold today:
            // - must have been holding yesterday, and sell now
            sold = prevHold + price;

            // If we rest today:
            // - either we were already resting
            // - or yesterday we just sold, so cooldown
            rest = Math.max(prevRest, prevSold);

            // ---- Example trace ----
            // prices = [1,2,3,0,2]
            // Day 1 init: hold=-1, sold=0, rest=0
            // Day 2 (price=2):
            //   hold = max(-1, 0-2) = -1
            //   sold = -1+2 = 1
            //   rest = max(0,0) = 0
            // Day 3 (price=3):
            //   hold = max(-1,0-3) = -1
            //   sold = -1+3 = 2
            //   rest = max(0,1) = 1
            // Day 4 (price=0):
            //   hold = max(-1,1-0) = 1   <-- buy at 0
            //   sold = -1+0 = -1
            //   rest = max(1,2) = 2
            // Day 5 (price=2):
            //   hold = max(1,2-2) = 1
            //   sold = 1+2 = 3           <-- sell at 2
            //   rest = max(2,-1) = 2
        }

        // Answer = best of resting or sold (not holding)
        return Math.max(rest, sold);  // returns 3
    }
}
