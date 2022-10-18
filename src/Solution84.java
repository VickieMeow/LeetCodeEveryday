import java.util.Stack;

public class Solution_84 {


    /*//2.栈
    //维护一个递增栈，如果待压入元素小于栈顶元素，则找到栈顶元素左右边界
    public int largestRectangleArea2(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for(int i = 0;i < heights.length ; i++){
            while (stack.peek()!=-1 && heights[stack.peek()]>heights[i])
                res = Math.max(res,heights[stack.peek()] * (i - stack.pop()));
            stack.push(i);
        }
        while (stack.peek() != -1){
            res = Math.max(res,heights[stack.peek()] * (heights.length - stack.pop()));
        }
        return res;
    }*/


    //2.栈方法
    //维护一个递增栈，如果待压入元素小于栈顶元素，则找到栈顶元素左右边界
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;

        for(int i = 0;i < heights.length ; i++){
            while (stack.peek()!=-1 && heights[stack.peek()] >= heights[i])//为什么是大于等于
                res = Math.max(res,heights[stack.pop()] * (i - stack.peek()-1));
            //为什么不能写成res = Math.max(res,heights[stack.peek()] * (i - stack.pop()));
            stack.push(i);
        }

        while (stack.peek() != -1){
            res = Math.max(res,heights[stack.pop()] * (heights.length - stack.peek()-1));
        }
        return res;
    }




}
