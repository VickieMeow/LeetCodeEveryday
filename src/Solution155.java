import java.util.Stack;

public class Solution155 {
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> min;//维护栈顶为当前stack内最小的元素

        public MinStack() {
            stack = new Stack<Integer>();//Stack内不能放int，而应该放Integer对象
            min = new Stack<Integer>();
            min.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            stack.push(x);
            if(x <= min.peek()) min.push(x);//注意小于等于判断，考虑重复元素情况
        }

        public void pop() {
            if(stack.isEmpty()) return;
            int temp = stack.pop();
            // 注意：声明成 int 类型，这里完成了自动拆箱，
            // 从 Integer 转成了 int，因此下面的比较可以使用 "==" 运算符
            // 如果把 temp 变量声明成 Integer 类型，下面的比较就得使用 equals 方法
            if(temp == min.peek()) min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
