class Solution {
    public int[] replaceElements(int[] arr) {
        int n=arr.length;

        if(arr.length==1){
            return new int[]{-1};
        }
        else if(arr.length==2){
            return new int[]{arr[1],-1};
        }
        int ans[] = new int[n];


        int max=Math.max(arr[n-1],arr[n-2]);

        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                ans[i]=-1;
                continue;
            }else if(i==n-2){
                ans[i]=arr[n-1];
                continue;
            }else{
                if(arr[i]>max){
                    ans[i]=max;
                    max=arr[i];
                }else{
                    ans[i]=max;
                }
            }
        }
        return ans;
        
    }
}