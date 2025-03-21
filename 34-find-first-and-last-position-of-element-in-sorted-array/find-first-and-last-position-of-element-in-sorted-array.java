class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int start = -1;
        int end = -1;
        
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                start = mid;
                right = mid - 1;  
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }   
        
        left = 0; right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                end = mid;
                left = mid + 1; 
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return new int[]{start,end};
        
    }
}