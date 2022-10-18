//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
//
// 说明:
//
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//
//
// 示例:
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6]
// Related Topics 数组 双指针

import java.util.Arrays;

public class Solution_88 {

    //1.合并后排序
    //O((m+n)log(m+n))
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }

    //2.双指针法（需要额外空间）
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1,0,nums1_copy,0,m);
        int p1 = 0,p2 = 0;
        int p = 0;

        while (p1 < m && p2 < n){
            nums1[p++] = nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++]:nums2[p2++];
        }
        if(p2 < n) System.arraycopy(nums2,p2,nums1,p,m+n-p);
        if(p1 < m) System.arraycopy(nums1_copy,p1,nums1,p,m+n-p);
    }

    //3.双指针法（原地修改）
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while ((p1>=0) && (p2>=0))
            nums1[p] = nums1[p1] < nums2[p2] ? nums2[p2++]:nums1[p1++];
        System.arraycopy(nums2,0,nums1,0,p2+1);

    }






}

