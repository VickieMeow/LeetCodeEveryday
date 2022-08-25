/**
 * 移动零
 * 类比27题，先删除值为0的元素，再把数组后面多余的位置都置为零
 * @author miaomeiqi
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for ( ; slow < nums.length; slow++) {
            nums[slow] = 0;
        }

    }

    void moveZeroes2(int[] nums) {
        // 去除 nums 中的所有 0，返回不含 0 的数组长度
        int p = removeElement(nums, 0);
        // 将 nums[p..] 的元素赋值为 0
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                //注意这里是先赋值再++，和26稍有差异
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
