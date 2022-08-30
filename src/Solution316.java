import java.util.Stack;

/**
 * 去除重复数字
 * 单调栈保证顺序，布尔数组保证仅出现一次，计数数组保证字典序
 * 每压入一个字符时，前一个字符如果字典序较大，看看前一个字符之后还会不会出现，如果还有，那就给它pop出来
 * @author miaomeiqi
 */
public class Solution316 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] isInStack = new boolean[256];
        int[] charNums = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charNums[c]++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charNums[c]--;
            if (isInStack[c]) {
                continue;
            }
            while (!stack.isEmpty()) {
                char topChar = stack.peek();
                if (topChar > c && charNums[topChar] > 0) {
                    stack.pop();
                    isInStack[topChar] = false;
                } else {
                    break;
                }
            }
            stack.push(c);
            isInStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();

    }
}