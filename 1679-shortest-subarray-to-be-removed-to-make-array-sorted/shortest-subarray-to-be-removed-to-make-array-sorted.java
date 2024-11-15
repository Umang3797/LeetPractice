class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        if(arr.length==1)
            return 0;
        
        int left=0;
        while (left + 1 < arr.length && arr[left] <= arr[left + 1]) {
            left++;
        }
        
        int right=arr.length-1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        
        if(left>=right)
            return 0;
        
        // int ans=Integer.MAX_VALUE;
        int ans=right;
        int l=0, r=right;
        while(l<=left){
            r=right;
            while(r<arr.length && arr[l]>arr[r]){
                r++;
            }
            ans = Math.min(ans,r-l-1);
            l++;
        }
        
        return ans;
        
        
        
        
        
        
//         int ans=0;
//         Stack<Integer> stack = new Stack();
//         stack.push(arr[0]);
        
//         for(int i=1;i<arr.length;i++){
//             if(!stack.isEmpty() && arr[i]>=stack.peek()){
//                 stack.push(arr[i]);
//             }else{
//                 while(!stack.isEmpty() && arr[i]<stack.peek()){
//                     stack.pop();
//                     ans++;
//                 }
//                 stack.push(arr[i]);
//             }
//         }
        
//         return ans;
        
    }
}