class Solution:
    def convert(self, s: str, numRows: int) -> str:
        # Edge case: if only one row, return original string
        if numRows == 1:
            return s

        # Initialize current row index and direction
        i = 0  # Current row index
        d = 1  # Direction: 1 for down, -1 for up

        # Create a list of empty lists for each row
        rows = [[] for _ in range(numRows)]

        # Place each character into the correct row
        for char in s:
            rows[i].append(char)

            # Change direction at the top or bottom row
            if i == 0:
                d = 1  # Go down
            elif i == numRows - 1:
                d = -1  # Go up

            # Move to the next row based on direction
            i += d

        # Combine all rows into the final result
        result = ''
        for row in rows:
            result += ''.join(row)

        return result
