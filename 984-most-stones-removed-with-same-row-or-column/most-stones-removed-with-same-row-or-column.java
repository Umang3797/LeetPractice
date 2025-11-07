class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        
        // 1. Create Adjacency List
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        // 2. Build the Graph
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {       
                // Check if stones[i] and stones[j] share a row OR a column
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        // 3. Find Connected Components
        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adjList, visited);
                components++;
            }
        }
        
        // 4. Return total stones - components
        return n - components;
    }
    public void dfs(int source, List<List<Integer>> adjList, boolean[] visited) {
        visited[source] = true;
        for (int neighbor : adjList.get(source)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited);
            }
        }
    }
}