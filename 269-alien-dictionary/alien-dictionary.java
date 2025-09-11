class Solution {
    public String alienOrder(String[] words) {
        // 1) Collect all unique characters
        Map<Character, Set<Character>> adj = new HashMap<>(); // graph: u -> {v...}
        Map<Character, Integer> indeg = new HashMap<>();      // in-degree for Kahn

        for (String w : words) {
            for (char ch : w.toCharArray()) {
                adj.putIfAbsent(ch, new HashSet<>());
                indeg.putIfAbsent(ch, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String a = words[i], b = words[i + 1];

            // Invalid ordering: "abc" before "ab"
            if (a.length() > b.length() && a.startsWith(b)) return "";

            int len = Math.min(a.length(), b.length());
            for (int j = 0; j < len; j++) {
                char c1 = a.charAt(j), c2 = b.charAt(j);
                if (c1 != c2) {
                    // add edge c1 -> c2 once
                    if (adj.get(c1).add(c2)) {
                        indeg.put(c2, indeg.get(c2) + 1);
                    }
                    break; // only the first difference matters
                }
            }
        }
        // 3) Kahn’s algorithm: start with in-degree 0 nodes
        Deque<Character> q = new ArrayDeque<>();
        for (Map.Entry<Character, Integer> e : indeg.entrySet()) {
            if (e.getValue() == 0)
                q.offer(e.getKey());
        }

        StringBuilder order = new StringBuilder();
        while (!q.isEmpty()) {
            char u = q.poll();
            order.append(u);
            for (char v : adj.get(u)) {
                indeg.put(v, indeg.get(v) - 1);
                if (indeg.get(v) == 0)
                    q.offer(v);
            }
        }
        // If we didn't output all letters, there's a cycle
        return order.length() == indeg.size() ? order.toString() : "";
    }
}