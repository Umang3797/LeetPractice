class Solution {
    int GATE=0;
    int wall=-1;
    int EMPTY = Integer.MAX_VALUE;
    int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public void wallsAndGates(int[][] rooms) {
        
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == GATE) {
                    q.add(new int[] { row, col });
                }
            }
        } 
        
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[] { r, c });
            }
        }
        
        // if(rooms.length==0){
        //     return;
        // }
        // for(int i=0;i<rooms.length;i++){
        //     for(int j=0;j<rooms[0].length;j++){
        //         if(rooms[i][j]==EMPTY){
        //             rooms[i][j]=bfs(rooms,i,j);
        //         }
        //     }
        // }
        
    }
    
//     private int bfs(int[][] rooms, int r, int c){
//         int m = rooms.length;
//         int n = rooms[0].length;
//         int[][] distance = new int[m][n];
//         Queue<int[]> q = new LinkedList<>();
//         q.add(new int[] {r, c});
        
//         while (!q.isEmpty()) {
//             int[] point = q.poll();
//             int row = point[0];
//             int col = point[1];
//             for(int[] direction: directions){
//                 int newrow = row + direction[0];
//                 int newcol = col + direction[1];
//                 if (newrow < 0 || newcol < 0 || newrow >= m || newcol >= n || rooms[newrow][newcol] == wall || distance[newcol][newcol] != 0) {
//                 continue;
//                 }
//                 distance[newrow][newcol]=distance[row][col]+1;
//                 if (rooms[r][c] == gate) {
//                     return distance[newrow][newcol];
//                 }
//                 q.add(new int[] { row, col });
//             }
            
//         }
//         return Integer.MAX_VALUE;
        
//     }
}