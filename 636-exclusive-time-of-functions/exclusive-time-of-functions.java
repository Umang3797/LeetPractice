class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] exclusiveTime = new int[n];
        Stack<Integer> stack = new Stack<>();
        int previousTime = 0;

        for (String log : logs) {
            String[] parts = log.split(":");
            int functionId = Integer.parseInt(parts[0]);
            String action = parts[1];
            int timestamp = Integer.parseInt(parts[2]);

            if (action.equals("start")) {
                if (!stack.isEmpty()) {
                    exclusiveTime[stack.peek()] += (timestamp - previousTime);
                }
                stack.push(functionId);
                previousTime = timestamp;
            } else { // action.equals("end")
                int endedFunction = stack.pop();
                exclusiveTime[endedFunction] += (timestamp - previousTime + 1);
                previousTime = timestamp + 1;
            }
        }

        return exclusiveTime;
    }
}

// 0end=6 - 0start=6 = 0+1=1
// 0end=5 - 0start=2 = 3+1=4
// 0end=7 - 0start=0 = 
