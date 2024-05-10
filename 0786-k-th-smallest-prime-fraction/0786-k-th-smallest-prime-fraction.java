class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Float[]> maxheap = new PriorityQueue<>((a,b)->Float.compare(b[0], a[0]));
        
        // Map<Float,String> map = new HashMap();
        
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                maxheap.add(new Float[]{(float)arr[i] / (float)arr[j], (float)arr[i], (float)arr[j]});
                // map.put((float)arr[i] / (float)arr[j],arr[i]+" "+arr[j]);
                if(maxheap.size()>k){
                    maxheap.remove();
                }
            }
        }
        // String ans=map.get(maxheap.remove());
        // String[] parts = ans.split(" ");
        // int[] result = new int[parts.length];
        // for (int i = 0; i < parts.length; i++) {
        //     result[i] = Integer.parseInt(parts[i]);
        // }
        
        Float[]ans = maxheap.remove();
        return new int[]{Math.round(ans[1]), Math.round(ans[2])};

    }
}