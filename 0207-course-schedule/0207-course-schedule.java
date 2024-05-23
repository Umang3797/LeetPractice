class Solution {
    List <Integer>[] adj;
    boolean seen[];
    boolean visited[];
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        adj = new ArrayList[n];

        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        seen = new boolean[n];
        visited = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(cycleFormed(i)){
                    return false;
                }
            }
        }
        return true;
        
    }
    
    private boolean cycleFormed(int i){
        visited[i]=true;
        for(int j : adj[i]){
            if(!visited[j]){
                if(cycleFormed(j)){
                    return true;
                }
            }
            else if(!seen[j]){
                return true;
            }
        }
        seen[i]=true;
        return false;
    }
}