class Solution {
    public int countComponents(int n, int[][] edges) {

        // Build adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u); // undirected
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adjList, visited);
                components++; // one full connected component explored
            }
        }

        return components;
    }

    private void dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited);
            }
        }
    }


    //     int[] parent = new int[n];
    //     for (int i = 0; i < n; i++){
    //         parent[i] = i;
    //     }
    //     int components = n;
    //     for (int[] e : edges) {
    //         int p1 = findParent(parent, e[0]);
    //         int p2 = findParent(parent, e[1]);
    //         if (p1 != p2) {
    //             parent[p1] = p2; // Union 2 component
    //             components--;
    //         }
    //     }
    //     return components;   
    // }
    // private int findParent(int[] parent, int i) {
    //     while (i != parent[i]) i = parent[i];
    //     return i; // Without Path Compression
    // }
}