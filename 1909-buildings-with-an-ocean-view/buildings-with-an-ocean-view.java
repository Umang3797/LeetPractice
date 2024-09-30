class Solution {
    public int[] findBuildings(int[] heights) {
        if(heights.length==1)
            return new int[]{0};
        List<Integer> ans = new ArrayList();
        int n = heights.length;
        ans.add(n-1);
        int max=heights[n-1];

        
        for(int i=heights.length-2;i>=0;i--){
            if(heights[i]>max){
                ans.add(i);
                max=heights[i];
            }
        }
        // Since we added buildings in reverse order, we need to reverse the list to return indices in ascending order
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(ans.size() - 1 - i); // Reverse the order of the indices
        }
        return result;

    }
}