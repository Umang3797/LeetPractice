class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Float> minheap = new PriorityQueue(Comparator.reverseOrder());
        
        Map<Float,String> map = new HashMap();
        
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                minheap.add((float)arr[i] / (float)arr[j]);
                map.put((float)arr[i] / (float)arr[j],arr[i]+" "+arr[j]);
                if(minheap.size()>k){
                    minheap.remove();
                }
            }
        }
        String ans=map.get(minheap.remove());
        System.out.println(ans);
        String[] parts = ans.split(" ");
        int[] result = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            result[i] = Integer.parseInt(parts[i]);
        }
        return result;
    }
}