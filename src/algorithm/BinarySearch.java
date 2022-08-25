package algorithm;

/**
 * @author miaomeiqi
 */
public class BinarySearch {

    /**
     * 普通二分查找
     * 搜索区间为闭区间 所以while判断条件为<=
     * 缺陷是，如果有序数组为[1,2,2,2,3]类似这样target=2，只能找到索引为2的数字，但无法返回左右边界（索引1）的2
     */
    int binarySearch1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        //注意
        while (left <= right) {
            //注意
            int mid = left + (right - left) /2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                //注意
                right = right - 1;
            } else if (nums[mid] < target) {
                //注意
                left = left + 1;
            }
        }
        return -1;
    }

    /**
     * 寻找左侧边界的二分搜索
     */
    int left_bound(int[] nums, int target) {
        int left = 0;
        // 注意
        int right = nums.length;

        // 注意
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 注意
                right = mid;
            }
        }
        // 此时 target 比所有数都大，返回 -1
        if (left == nums.length) {
            return -1;
        }
        // 判断一下 nums[left] 是不是 target
        return nums[left] == target ? left : -1;
    }


    /**
     * 寻找左边界的二分搜索，全闭区间写法
     */
    int left_bound2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 判断 target 是否存在于 nums 中
        // 此时 target 比所有数都大，返回 -1
        if (left == nums.length) {
            return -1;
        }
        // 判断一下 nums[left] 是不是 target
        return nums[left] == target ? left : -1;
    }



    /**
     * 寻找右边界的二分搜索
     */
    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 注意
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        // 注意 这里判断以及返回的是left - 1
        //return left - 1;
        if (left - 1 < 0) {
            return -1;
        }
        // 判断一下 nums[left] 是不是 target
        return nums[left - 1] == target ? (left - 1) : -1;
    }


    /**
     * 寻找右侧边界的二分搜索，全闭区间写法
     */
    int right_bound2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 这里改成收缩左侧边界即可
                left = mid + 1;
            }
        }
        // 最后改成返回 left - 1
        if (left - 1 < 0) {
            return -1;
        }
        return nums[left - 1] == target ? (left - 1) : -1;
    }


}
