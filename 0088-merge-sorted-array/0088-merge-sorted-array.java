class Solution {
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
    while (tail1 >= 0 && tail2 >= 0) {
        nums1[finished--] = (nums1[tail1] > nums2[tail2]) ? 
                             nums1[tail1--] : nums2[tail2--];
    }

    while (tail2 >= 0) { //only need to combine with remaining nums2
        nums1[finished--] = nums2[tail2--];
    }
}
}




/*
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int count=m+n-1;
        m--;
        n--;
        
        while(m>=0 && n>=0){
            if(nums1[m]>nums2[n]){
                nums1[count] = nums1[m];
                count--;
                m--;
            }
            else{
                nums1[count] = nums2[n];
                count--;
                n--;
            }
        }
        
        while(n>=0){
            nums1[count]=nums2[n];
            count--;
            n--;
        }
        
       // return nums1;
    }
}
*/