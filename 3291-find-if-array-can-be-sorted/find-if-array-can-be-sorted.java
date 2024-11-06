class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int[] setBits = new int[n];
        for (int i = 0; i < n; i++) {
            setBits[i] = countOnes(nums[i]);
        }
        
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (setBits[i] == setBits[i + 1] && nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;

                    temp = setBits[i];
                    setBits[i] = setBits[i + 1];
                    setBits[i + 1] = temp;

                    swapped = true;
                }
            }
        } while (swapped);
        
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false; 
            }
        }
        
        return true; 
    }
    
    private static int countOnes(int number) {
        int count = 0;
        while (number != 0) {
            count += (number & 1);
            number >>= 1;
        }
        return count;
    }
}