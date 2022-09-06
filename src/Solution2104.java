import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 子数组范围和
 * 思路是最小栈，利用最小栈构建出四个数组
 * minLeft 数组中当前数字左侧离这个数最近的小于它的数的下标
 * minRight 数组中当前数字右侧离这个数最近的小于它的数的下标
 * maxLeft 数组中当前数字左侧离这个数最近的大于它的数的下标
 * maxRight 数组中当前数字右侧离这个数最近的大于它的数的下标
 * 对于nums[i]来说，比如左侧第一个大于它的数为nums[left],右侧第一个大于它的数为nums[right]，
 * 那么以nums[i]为最大值的数组有(i-left)*(right-i)个，它们的最大值的和为(i-left)*(right-i)*nums[i]
 * 题目所求可以理解为，所有子数组的最大值的和，减去所有子数组的最小值的和
 *
 * while循环只要是一开一闭就可以，这样避免遗漏数据。但是max和min栈的判断条件开闭区间要相反（估计也是避免重复计算？）
 * @author miaomeiqi
 */
public class Solution2104 {

    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] minLeft = new int[n];
        int[] minRight = new int[n];
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        Deque<Integer> minStack = new ArrayDeque<Integer>();
        Deque<Integer> maxStack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            while (!minStack.isEmpty() && nums[minStack.peek()] > nums[i]) {
                minStack.pop();
            }
            minLeft[i] = minStack.isEmpty() ? -1 : minStack.peek();
            minStack.push(i);

            // 如果 nums[maxStack.peek()] == nums[i], 那么根据定义，
            // nums[maxStack.peek()] 逻辑上小于 nums[i]，因为 maxStack.peek() < i
            while (!maxStack.isEmpty() && nums[maxStack.peek()] <= nums[i]) {
                maxStack.pop();
            }
            maxLeft[i] = maxStack.isEmpty() ? -1 : maxStack.peek();
            maxStack.push(i);
        }
        minStack.clear();
        maxStack.clear();
        for (int i = n - 1; i >= 0; i--) {
            // 如果 nums[minStack.peek()] == nums[i], 那么根据定义，
            // nums[minStack.peek()] 逻辑上大于 nums[i]，因为 minStack.peek() > i
            while (!minStack.isEmpty() && nums[minStack.peek()] >= nums[i]) {
                minStack.pop();
            }
            minRight[i] = minStack.isEmpty() ? n : minStack.peek();
            minStack.push(i);

            while (!maxStack.isEmpty() && nums[maxStack.peek()] < nums[i]) {
                maxStack.pop();
            }
            maxRight[i] = maxStack.isEmpty() ? n : maxStack.peek();
            maxStack.push(i);
        }

        long sumMax = 0, sumMin = 0;
        for (int i = 0; i < n; i++) {
            sumMax += (long) (maxRight[i] - i) * (i - maxLeft[i]) * nums[i];
            sumMin += (long) (minRight[i] - i) * (i - minLeft[i]) * nums[i];
        }
        return sumMax - sumMin;
    }
}
