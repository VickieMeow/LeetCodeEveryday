/**
 * 删除数组中删除指定值的数字，类比26题，执行时稍有差别
 * @author miaomeiqi
 */
public class Solution27 {
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
