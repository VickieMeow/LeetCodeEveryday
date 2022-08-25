/**
 * @author miaomeiqi
 */
public class Solution26 {

    /**
     * 删除数组中重复项，原地修改
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
