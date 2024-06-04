class Tuple{
    int first;
    int second;
    int third;
    public Tuple(int first, int second, int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        int m = flights.length;
        
        for(int i=0;i<m;i++){
            list.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
        }
        
        Queue<Tuple> q = new LinkedList<>();
        //stops,nodes,cost
        q.add(new Tuple(0,src,0));
        
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[src]=0;
        
        while(!q.isEmpty()){
            Tuple it = q.peek();
            q.poll();
            int stop=it.first;
            int node=it.second;
            int cost=it.third;
            
            if(stop>k)
                continue;
            
            for(int[] i : list.get(node)){
                int adjNode=i[0];
                int edw=i[1];
                
                if(cost+edw<dist[adjNode] && stop<=k){
                    dist[adjNode]=cost+edw;
                    q.add(new Tuple(stop+1,adjNode,cost+edw));
                }
            }
        }
        
        
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
        
    }
}