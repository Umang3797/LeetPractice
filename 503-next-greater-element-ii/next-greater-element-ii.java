class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        
        Stack<Integer> s = new Stack();
        for(int i=0;i<n*2;i++){
            while(!s.isEmpty() && nums[s.peek()]<nums[i%n]){
                ans[s.pop()]=nums[i%n];
            }
            if(i<n) s.push(i);
        }
        return ans;
    }
}