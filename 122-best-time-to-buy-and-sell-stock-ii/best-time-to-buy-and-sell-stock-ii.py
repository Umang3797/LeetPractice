class Solution:
    def maxProfit(self, prices: List[int]) -> int:

        i=0
        low=prices[0]
        high=prices[0]
        profit=0
        n=len(prices)

        while i<n-1:
            # where to buy
            while i<n-1 and prices[i]>=prices[i+1]:
                i+=1
            low=prices[i]

            # where to sell
            while i<n-1 and prices[i]<=prices[i+1]:
                i+=1
            high=prices[i]

            profit+=high-low
        
        return profit