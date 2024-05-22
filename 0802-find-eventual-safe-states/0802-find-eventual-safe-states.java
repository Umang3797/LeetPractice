class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
//         int n = graph.length;
//         List<List<Integer>> list = new ArrayList<>();

//         for (int i = 0; i < n; i++) {
//             list.add(new ArrayList<>());
//         }

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < graph[i].length; j++) {
//                 if (graph[i][j] == 1) {
//                     list.get(i).add(j);
//                 }
//             }
//         }
        
//         int visit[]=  new int[n];
//         int pathvisit[] = new int[n];
//         int check[] = new int[n];
        
//         for(int i=0;i<n;i++){
//             if(visit[i]==0){
//                 dfs(i, list, visit, pathvisit, check);
//             }
//         }
//         List<Integer> safenodes = new ArrayList();
//         for(int i=0;i<n;i++){
//             if(check[i]==1)
//                 safenodes.add(i);
//         }
        
//         return safenodes;
        
        int n = graph.length;
        
        // Using graph as is, no need to create a new adjacency list
        // We only need to track the states of each node
        int[] visit = new int[n];  // 0 = not visited, 1 = visiting, 2 = safe
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (isSafe(i, graph, visit)) {
                result.add(i);
            }
        }
        
        Collections.sort(result);  // Ensure the result is sorted
        return result;
        
    }
    
//     private boolean dfs(int node, List<List<Integer>> list, int visit[], int pathvisit[], int check[]){
//         visit[node]=1;
//         pathvisit[node]=1;
//         check[node]=0;
        
//         for(int i:list.get(node)){
//             if(visit[i]==0){
//                 if(dfs(i,list,visit,pathvisit,check)==true){
//                     return true;
//                 }
//             }else if(pathvisit[i]==1){
//                 return true;
//             }
//         }
//         check[node]=1;
//         pathvisit[node]=0;
//         return false;
//     }
    private boolean isSafe(int node, int[][] graph, int[] visit) {
        if (visit[node] != 0) {
            return visit[node] == 2;  // Return true if the node is safe
        }
        
        visit[node] = 1;  // Mark the node as visiting
        
        for (int neighbor : graph[node]) {
            if (!isSafe(neighbor, graph, visit)) {
                return false;  // If any neighbor is not safe, the current node is not safe
            }
        }
        
        visit[node] = 2;  // Mark the node as safe
        return true;
    }
}