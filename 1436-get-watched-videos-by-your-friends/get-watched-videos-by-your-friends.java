class Solution {
    class Pair implements Comparable<Pair> {
        String video;
        int frequency;

        // Constructor
        Pair(String video, int frequency) {
            this.video = video;
            this.frequency = frequency;
        }

        // Custom comparison logic
        @Override
        public int compareTo(Pair that) {
            // If frequencies are the same, sort by video name (alphabetically)
            if (this.frequency == that.frequency) {
                return this.video.compareTo(that.video); 
            }
            // Otherwise, sort by frequency (increasing order) 
            return this.frequency - that.frequency;
        }
    }
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        // Queue for BFS, initialized with your own ID
        Queue<Integer> q = new LinkedList<>();
        q.offer(id); // [00:13:06]

        // Set to keep track of visited people 
        HashSet<Integer> visited = new HashSet<>();
        visited.add(id); 

       
        int currentLevel = 0; 

        while (!q.isEmpty()) {
            // Stop BFS if we have processed the target level
            if (currentLevel == level) {
                break; 
            }
                
            int size = q.size(); 
            // Process all nodes at the current level
            for (int i = 0; i < size; i++) { 
                int currentID = q.poll(); 

                // Iterate through the current person's friends
                for (int friend : friends[currentID]) { 
                    if (!visited.contains(friend)) { 
                        visited.add(friend); 
                        q.offer(friend); 
                    }
                }
            }
            currentLevel++; 
        }

        // --- 2. Count Frequencies of Watched Videos ---
        // 'q' now contains all friends at the target 'level'

        // Map to store video frequency 
        HashMap<String, Integer> frequencyMap = new HashMap<>();

        while (!q.isEmpty()) { 
            int friendID = q.poll(); 
            
            // Get watched videos for this friend and update frequencies
            for (String video : watchedVideos.get(friendID)) { 
                frequencyMap.put(video, frequencyMap.getOrDefault(video, 0) + 1); 
            }
        }

        // --- 3. Sort the Results ---

        // Create a list of Pair objects for sorting
        List<Pair> videoList = new ArrayList<>();
        for (String video : frequencyMap.keySet()) { 
            videoList.add(new Pair(video, frequencyMap.get(video))); 
        }

        // Sort the list using the custom compareTo method in the Pair class 
        Collections.sort(videoList);

        // --- 4. Prepare Final Result List ---

        // Extract the video names from the sorted list 
        List<String> result = new ArrayList<>();
        for (Pair pair : videoList) {
            result.add(pair.video); 
        }

        return result; 
    }
}