class Solution {
    public String removeDuplicates(String s) {
        // Use ArrayDeque as a stack (faster, non-legacy)
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If top equals current, pop; otherwise push
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        // Build result (stack is reversed order)
        StringBuilder sb = new StringBuilder(stack.size());
        while (!stack.isEmpty()) 
            sb.append(stack.pop());
        return sb.reverse().toString();
    }
}