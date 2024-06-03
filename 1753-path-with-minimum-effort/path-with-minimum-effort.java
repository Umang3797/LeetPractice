class Tuple{
    int distance;
    int row;
    int col;
    public Tuple(int distance, int row, int col){
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);
        
        int n = heights.length;
        int m = heights[0].length;
        int dist[][] = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=0;
        pq.add(new Tuple(0,0,0));
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};
        
        while(!pq.isEmpty()){
            Tuple it = pq.peek();
            pq.remove();
            int tupleDistance = it.distance;
            int tupleRow = it.row;
            int tupleCol = it.col;
            
            if(tupleRow==n-1 && tupleCol==m-1)
                return tupleDistance;
            
            
            for(int i=0;i<4;i++){
                int newrow = tupleRow+dr[i];
                int newcol = tupleCol+dc[i];
                
                if(newrow>=0 && newrow<n && newcol>=0 && newcol<m){
                    int newEffort = Math.max(Math.abs(heights[tupleRow][tupleCol] - heights[newrow][newcol]), tupleDistance);
                    if(newEffort<dist[newrow][newcol]){
                        dist[newrow][newcol]=newEffort;
                        pq.add(new Tuple(newEffort, newrow, newcol));
                    }
                }
            }
            
            
        }
        return 0;
    }
}