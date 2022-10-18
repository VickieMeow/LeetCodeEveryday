public class Solution4 {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int index1 = 0;
        int index2 = 0;
        int[] resArr = new int[m+n];
        int pointer = 0;
        if (n == 0) {
            if (m%2 == 1) {
                return nums1[m/2];
            } else {
                return (nums1[m/2-1] + nums1[m/2+1])/2;
            }
        } else if (m == 0) {
            if (n%2 == 1) {
                return nums2[n/2];
            } else {
                return (nums2[n/2-1] + nums2[n/2+1])/2;
            }
        }
        while (index1 < m && index2 < n) {
            if (nums1[index1] < nums2[index2]) {
                resArr[pointer] = nums1[index1];
                index1++;
                pointer++;
            } else {
                resArr[pointer] = nums2[index2];
                index2++;
                pointer++;
            }
        }
        while (index1 < m) {
            resArr[pointer] = nums1[index1];
            index1++;
            pointer++;
        }
        while (index2 < n) {
            resArr[pointer] = nums2[index2];
            index2++;
            pointer++;
        }
        if ((m+n)%2 == 0) {
            return (resArr[(m+n)/2-1] + resArr[(m+n)/2])/2;
        }
        return resArr[(m+n)/2];
    }
}
