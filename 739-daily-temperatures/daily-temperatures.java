class Solution {
    public int[] dailyTemperatures(int[] A) {
        //monotonic stack
        Stack<int[]> stack = new Stack();
        int n = A.length;
        int[] ans = new int[n];
        
        for(int i=n-1;i>=0;i--){
            while (!stack.isEmpty() && A[i] >= stack.peek()[0]) {
                stack.pop();
            }
            
            if(!stack.isEmpty())
                ans[i]=stack.peek()[1]-i;
            
            stack.push(new int[]{A[i],i});
                
            
        }
        return ans;
    }
}