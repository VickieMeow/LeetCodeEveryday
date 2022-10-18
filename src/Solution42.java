//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
//
// 示例:
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6
// Related Topics 栈 数组 双指针

import java.util.Stack;

public class Solution42 {


    //2.动态规划
    //时间复杂度最低 O(N)
    //将每个一柱子i的左右边界保存到数组里，防止重复计算
    public int trap2(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    //3.栈
    //时间复杂度较高
    //维护一个递减栈，若新元素高度高于栈顶元素高度，则出栈，计算新元素与栈顶之间积水
    public int trap3(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length){
            while (!stack.isEmpty() && height[stack.peek()] < height[current]){
                int h = height[stack.pop()];
                if(stack.isEmpty()) break;
                int distance = current - stack.peek() - 1;
                int min =  Math.min(height[stack.peek()],height[current]);
                res += distance * (min - h);
            }
            stack.push(current);
            current++;
        }
        return res;
    }



}




