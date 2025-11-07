class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // 1. Create Adjacency List
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        // 2. Populate Adjacency List from edges
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }   
        // 3. Call DFS helper function
        return dfs(0, -1, adjList, hasApple);
    }
    public int dfs(int source, int parent, List<List<Integer>> adjList, List<Boolean> hasApple) {
        int totalTime = 0;
        for (int neighbor : adjList.get(source)) { 
            if (neighbor == parent) {
                continue;
            }
            int timeTakenByChild = dfs(neighbor, source, adjList, hasApple);

            if (timeTakenByChild > 0 || hasApple.get(neighbor) == true) {
                totalTime += timeTakenByChild + 2;
            }
        }
        return totalTime;
    }
}