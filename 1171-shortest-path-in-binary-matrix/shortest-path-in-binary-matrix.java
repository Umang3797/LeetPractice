class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length - 1][grid.length - 1] != 0) {
            return -1;
        }

        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 1; // Starting point has distance 1
        q.add(new int[]{0, 0, 1}); // {row, col, distance}

        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int row = tmp[0];
            int col = tmp[1];
            int dis = tmp[2];

            if (row == n - 1 && col == n - 1) {
                return dis; // Reached destination
            }

            for (int i = 0; i < 8; i++) {
                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 0 && dis + 1 < dist[nrow][ncol]) {
                    dist[nrow][ncol] = dis + 1;
                    q.add(new int[]{nrow, ncol, dis + 1});
                }
            }
        }
        return -1; // No path found
    }
    
}