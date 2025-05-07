class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
         # Convert list to set for O(1) lookups
        s = set(nums)
        longest = 0

        for num in s:
            # Only start counting if num is the start of a sequence
            if num - 1 not in s:
                next_num = num + 1
                length = 1

                # Expand the sequence
                while next_num in s:
                    length += 1
                    next_num += 1

                # Update the longest length
                longest = max(longest, length)

        return longest
        