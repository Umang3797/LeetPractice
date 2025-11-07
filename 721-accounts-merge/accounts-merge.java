class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> adjMap = new HashMap<>();
        
        // 1. Build the Adjacency Map (Graph)
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            for (int i = 2; i < account.size(); i++) {
                String currentEmail = account.get(i);
                // Add edge from firstEmail to currentEmail
                if (!adjMap.containsKey(firstEmail)) {
                    adjMap.put(firstEmail, new ArrayList<>());
                }
                adjMap.get(firstEmail).add(currentEmail);
                
                // Add edge from currentEmail to firstEmail (undirected)
                if (!adjMap.containsKey(currentEmail)) {
                    adjMap.put(currentEmail, new ArrayList<>());
                }
                adjMap.get(currentEmail).add(firstEmail);
            }
        }

        List<List<String>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        
        // 2. Iterate through accounts to find connected components
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            if (!visited.contains(firstEmail)) {
                // This is a new component, so create a new list for it
                List<String> sublist = new ArrayList<>();
                
                // 3. Call DFS to find all connected emails
                dfs(firstEmail, adjMap, visited, sublist);
                // 4. Sort emails and add the name
                Collections.sort(sublist);
                // Add the name at the beginning of the list
                sublist.add(0, account.get(0));
                result.add(sublist);
            }
        }
        return result;
    }
    public void dfs(String sourceEmail, 
                    Map<String, List<String>> adjMap, 
                    Set<String> visited, 
                    List<String> sublist) {
    
        visited.add(sourceEmail);
        sublist.add(sourceEmail);
        // Check if this email has any neighbors at all
        if (!adjMap.containsKey(sourceEmail)) {
            return;
        }
        for (String neighbor : adjMap.get(sourceEmail)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, adjMap, visited, sublist);
            }
        }
    }
}