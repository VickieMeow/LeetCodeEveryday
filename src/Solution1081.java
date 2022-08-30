import java.util.Stack;

/**
 * 不同字符的最小子序列
 * 同316题 单调栈
 * @author miaomeiqi
 */
public class Solution1081 {
    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        int[] counter = new int[256];
        boolean[] isInStack = new boolean[256];
        for (char c : s.toCharArray()) {
            counter[c] ++;
        }
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i)]--;
            if (isInStack[s.charAt(i)]) continue;
            while (!stack.isEmpty() && stack.peek() > s.charAt(i) && counter[stack.peek()] > 0) {
                isInStack[stack.peek()] = false;
                stack.pop();
            }
            stack.push(s.charAt(i));
            isInStack[s.charAt(i)] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
