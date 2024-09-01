class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        Stack<Integer> stack = new Stack<>();
        // the distance of next or previous less
        int[] left = new int[n];
        int[] right = new int[n];

        for(int i = 0; i < n; i++){
            right[i] = n - i;
        }

        for(int i = 0; i < n; i ++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                right[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i+1 : i - stack.peek();
            stack.push(i);
        }

        int res = 0;
        int mod = (int)1e9 + 7;
        for(int i = 0; i < n; i++){
            res = (int) ((res + (long)arr[i]*left[i]*right[i])% mod);
        }
        return res;
    }
}