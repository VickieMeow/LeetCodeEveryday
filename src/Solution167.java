/**
 * 两数之和II -- 输入有序数组
 * 同样是双指针问题
 * @author miaomeiqi
 */
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int slow = 0, fast = numbers.length - 1;
        while (slow < fast) {
            if (numbers[slow] + numbers[fast] == target) {
                res[0] = slow+1;
                res[1] = fast+1;
                return res;
            } else if (numbers[slow] + numbers[fast] < target) {
                slow++;
            } else if (numbers[slow] + numbers[fast] > target) {
                fast--;
            }
        }
        return res;
    }

}
