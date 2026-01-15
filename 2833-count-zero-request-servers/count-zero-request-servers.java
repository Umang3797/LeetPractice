class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = logs.length;
        int q = queries.length;

        // 1. Prepare Queries with Original Indices
        // We need to sort queries by time, but we must return the answer in the original order.
        // So, we store {queryTime, originalIndex}.
        int[][] sortedQueries = new int[q][2];
        for (int i = 0; i < q; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        // 2. Sort logs by time (index 1) and queries by time (index 0)
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        int[] serverCount = new int[n + 1]; // Tracks how many times each server appears in the current window
        int activeServers = 0;             // Number of unique servers currently in the window
        int left = 0;                      // Left pointer (to remove old logs)
        int right = 0;                     // Right pointer (to add new logs)
        int[] results = new int[q];

        // 4. Process each query using the sliding window
        for (int i = 0; i < q; i++) {
            int currentTime = sortedQueries[i][0];
            int originalIdx = sortedQueries[i][1];
            // Expand the window: Add all logs that occurred up to currentTime
            while (right < m && logs[right][1] <= currentTime) {
                int serverId = logs[right][0];
                if (serverCount[serverId] == 0) {
                    activeServers++; // First time seeing this server in the current window
                }
                serverCount[serverId]++;
                right++;
            }
            // Shrink the window: Remove logs that occurred before (currentTime - x)
            while (left < m && logs[left][1] < currentTime - x) {
                int serverId = logs[left][0];
                serverCount[serverId]--;
                if (serverCount[serverId] == 0) {
                    activeServers--; // Server is no longer present in the current window
                }
                left++;
            }
            // The answer for this query is: (Total Servers - Active Servers)
            results[originalIdx] = n - activeServers;
        }
        return results;
    }
}