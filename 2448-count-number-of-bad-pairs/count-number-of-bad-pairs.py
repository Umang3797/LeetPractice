class Solution:
    def countBadPairs(self, nums: List[int]) -> int:
        good_pair=0
        total_pair=0
        count=defaultdict(int)
        for i in range(len(nums)):
            total_pair+=i
            good_pair+=count[nums[i]-i]
            count[nums[i]-i]+=1
        
        return total_pair - good_pair
        