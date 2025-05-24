class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        long s1 = 0, s2 = 0;
        int c01 = 0, c02 = 0;

        for (int i = 0; i < n1; i++) {
            if (nums1[i] == 0) {
                c01++;
                nums1[i] = 1;
            }
            s1 += nums1[i];
        }

        for (int i = 0; i < n2; i++) {
            if (nums2[i] == 0) {
                c02++;
                nums2[i] = 1;
            }
            s2 += nums2[i];
        }

        if ((s1 < s2 && c01 == 0) || (s1 > s2 && c02 == 0)) {
            return -1;
        }

        return Math.max(s1, s2);

    }
}