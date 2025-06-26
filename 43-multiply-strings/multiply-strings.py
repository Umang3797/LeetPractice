class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        
        # Edge case: if either is "0"
        if num1 == "0" or num2 == "0":
            return "0"

        m, n = len(num1), len(num2)
        result = [0] * (m + n)  # max possible length

        # Reverse iterate through both numbers
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                # Multiply digits
                mul = (ord(num1[i]) - ord('0')) * (ord(num2[j]) - ord('0'))
                # Position in result array
                p1, p2 = i + j, i + j + 1
                # Add to existing value at position p2
                sum_ = mul + result[p2]
                result[p2] = sum_ % 10
                result[p1] += sum_ // 10

        # Skip leading zeros and build result string
        res = []
        for num in result:
            if not res and num == 0:
                continue
            res.append(str(num))
        return ''.join(res) if res else "0"

        