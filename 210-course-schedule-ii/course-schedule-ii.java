class Solution {
    List <Integer>[] adjacency;
    boolean seen[];
    boolean visited[];
    Stack<Integer> stack;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //creating adjacency matrix
        adjacency = new ArrayList[numCourses]; 
        for(int i=0;i<numCourses;i++)
            adjacency[i] = new ArrayList();
        
        //visited to keep track of nodes visited while traversing
        visited = new boolean[numCourses];
        //seen to keep a track of not-forming loops
        seen = new boolean[numCourses];
        
        //filling up the adjacency matrix, nodes with its neighbours.
        for(int i=0;i<prerequisites.length;i++)
            adjacency[prerequisites[i][1]].add(prerequisites[i][0]);
        
        //dfs
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(cycleFormed(i))
                    return new int[]{};
            }
        }
        
        visited = new boolean[numCourses];
        stack = new Stack();
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                topologicalsort(i);
            }
        }
        
        int[] res = new int[stack.size()];
        for(int i=0;i<res.length;i++)
            res[i] = stack.pop();
        
        
        return res;
        
    }
    
    private boolean cycleFormed(int i){
        visited[i]=true;
        seen[i]=true;
        for(int j : adjacency[i]){
            if(!visited[j]){
                if(cycleFormed(j)){
                    return true;
                }
            }
            else if(seen[j]){
                return true;
            }
        }
        seen[i]=false;
        return false;
    }
    
    private void topologicalsort(int i){
        visited[i] = true;
        for(int j : adjacency[i]){
            if(!visited[j]){
                topologicalsort(j);
            }
        }
        
        stack.push(i);
    }
}