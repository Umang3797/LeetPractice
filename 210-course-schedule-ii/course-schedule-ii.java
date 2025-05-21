class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> ans = new ArrayList();
        // Build adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] course : prerequisites) {
            adjList.get(course[0]).add(course[1]);
        }

        // States: 0 = unvisited, 1 = visiting, 2 = visited
        int[] states = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, adjList, states, ans)) {
                return new int[]{};
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    private boolean dfs(int node, List<List<Integer>> adjList, int[] states, List<Integer> ans) {
        if (states[node] == 2) {
            return true; // already processed
        }
        if (states[node] == 1) {
            return false; // cycle detected
        }

        states[node] = 1; // mark as visiting

        for (int neighbor : adjList.get(node)) {
            if (!dfs(neighbor, adjList, states, ans)) {
                return false;
            }
        }

        states[node] = 2; // mark as visited
        ans.add(node);
        return true;
    }
}