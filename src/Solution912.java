package midautum;

/**
 * 排序数组
 * 使用了归并排序
 */
public class Solution912 {
    class Solution {
        public int[] sortArray(int[] nums) {
            Merge merge = new Merge();
            merge.sort(nums);
            return nums;
        }
    }

    class Merge {
        int[] temp;

        public void sort(int[] nums) {
            temp = new int[nums.length];
            sort(nums, 0, nums.length - 1);
        }


        void sort(int[] nums, int low, int high) {
            if (low == high) {
                return;
            }
            int mid = low + (high - low) / 2;
            sort(nums, low, mid);
            sort(nums, mid+1, high);
            merge(nums, low, mid, high);
        }

        void merge(int[] nums, int low, int mid, int high) {
            for (int i = low; i <= high; i++) {
                temp[i] = nums[i];
            }
            int i = low, j = mid + 1;
            for (int p = low; p <= high; p++) {
                if (i == mid + 1) {
                    nums[p] = temp[j++];
                } else if (j == high + 1) {
                    nums[p] = temp[i++];
                } else if (temp[i] < temp[j]) {
                    nums[p] = temp[i++];
                } else {
                    nums[p] = temp[j++];
                }
            }
        }

    }
}
