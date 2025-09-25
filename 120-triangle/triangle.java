class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] memo = new int[n][n];
        for (int[] row : memo) Arrays.fill(row, Integer.MAX_VALUE);
        return dfs(0, 0, triangle, memo);
    }
    private int dfs(int i, int j,List<List<Integer>> triangle, int[][] memo) {
        if (i == triangle.size() - 1)
            return triangle.get(i).get(j);

        if (memo[i][j] != Integer.MAX_VALUE)
            return memo[i][j];

        int downLeft = dfs(i + 1, j, triangle, memo);
        int downRight = dfs(i + 1, j + 1, triangle, memo);
        memo[i][j] = triangle.get(i).get(j) + Math.min(downLeft, downRight);
        return memo[i][j];
    }
}