class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;

        int r = 0;        // start at top row
        int c = n - 1;    // start at rightmost column

        // "staircase" walk: O(m + n)
        while (r < m && c >= 0) {
            int val = matrix[r][c];
            if (val == target) return true;
            else if (val > target) c--;  // too big -> move left
            else r++; // too small -> move down
        }
        return false;
    }
}  