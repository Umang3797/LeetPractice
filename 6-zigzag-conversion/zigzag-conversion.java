class Solution {
    public String convert(String s, int numRows) {
        // Edge case: if only one row, return original string
        if (numRows == 1) {
            return s;
        }

        // Current row index
        int i = 0;

        // Direction: 1 = going down, -1 = going up
        int d = 1;

        // Create a list of StringBuilders (one for each row)
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int r = 0; r < numRows; r++) {
            rows[r] = new StringBuilder();
        }

        // Place each character into the correct row
        for (char ch : s.toCharArray()) {
            rows[i].append(ch);

            // Change direction at top or bottom
            if (i == 0) {
                d = 1;          // go down
            } else if (i == numRows - 1) {
                d = -1;         // go up
            }

            // Move to next row
            i += d;
        }

        // Combine all rows into final result
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}