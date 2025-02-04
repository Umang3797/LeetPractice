class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rowMap = new HashMap<>();
        int count = 0;

        for (int[] row : grid) {
            String rowKey = Arrays.toString(row);
            rowMap.put(rowKey, rowMap.getOrDefault(rowKey, 0) + 1);
        }

        for(int j=0;j<n;j++){
            int[] temp=new int[n];
            for(int i=0;i<n;i++){
                temp[i]=grid[i][j];
            }
            String colKey = Arrays.toString(temp);
            count += rowMap.getOrDefault(colKey, 0);
        }
        return count;
    }
}