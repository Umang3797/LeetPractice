class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:

        left = 0
        max_len = 0
        zeros = 0
        
        for right in range(len(nums)):
            if nums[right] == 0:
                zeros += 1
            
            # talk: shrink window until we have at most k zeros
            while zeros > k:
                if nums[left] == 0:
                    zeros -= 1
                left += 1
            
            # talk: window from left to right has at most k zeros
            max_len = max(max_len, right - left + 1)
        
        return max_len

            