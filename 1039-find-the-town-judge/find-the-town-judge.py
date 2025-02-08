from collections import defaultdict
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if not trust and n == 1:
            return 1
        trust_counts = [0] * (n + 1)  # Array to track trust balance
        for a, b in trust:
            trust_counts[a] -= 1  # Person a trusts someone, so they can't be a judge
            trust_counts[b] += 1  # Person b is trusted by a

        for i in range(1, n + 1):
            if trust_counts[i] == n - 1:
                return i
        return -1 



        