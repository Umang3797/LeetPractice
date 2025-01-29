class Solution {
public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
}

public void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }

}
}

/*
nums = [1,2,3,4,5,6,7], k = 3
nums = [7,6,5,4,3,2,1]
nums = [5,6,7,4,3,2,1] -> 0 to k-1
nums = [5,6,7,1,2,3,4] -> k to last
*/