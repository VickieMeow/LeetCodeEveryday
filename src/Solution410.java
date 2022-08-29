/**
 * 分割数组的最大值
 * 思路同1011一样，只是变量选择时需要仔细考虑一下
 * 一般来说求谁就返回谁，给定的条件用于做二分搜索判断范围
 * @author miaomeiqi
 */
public class Solution410 {
    /**
     * 数组个数m用于做二分查找的限定条件
     * 在各自和最大值为[left, right]区间中，选出符合划分为m个数组的情况，并找左边界
     */
    public int splitArray(int[] nums, int m) {
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            left = Math.max(left, nums[i]);
            right += nums[i];
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(nums, mid) <= m) {
                right = mid;
            } else if (f(nums, mid) > m) {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 各自和的最大值为x的情况下
     * 能划分为几个数组
     * 返回数组个数
     */
    public int f(int[] nums, int x) {
        int count = 0;
        for (int i = 0; i < nums.length; ) {
            int temp = x;
            while (i < nums.length) {
                if (temp < nums[i]) {
                    break;
                } else {
                    temp -= nums[i];
                    i++;
                }
            }
            count++;
        }
        return count;
    }
}
