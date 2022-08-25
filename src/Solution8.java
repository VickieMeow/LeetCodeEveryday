public class Solution8 {

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        System.out.println(solution8.myAtoi("2147483646"));
        System.out.println(Integer.MAX_VALUE);
    }

    public int myAtoi(String s) {
        int res = 0;
        int flag = 1;
        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index < s.length() && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
            flag = s.charAt(index) == '-' ? -1 : 1;
            index++;
        }
        while (index < s.length()) {
            char curCh = s.charAt(index);
            int curNum = curCh - '0';
            if (isNumber(curCh)) {
                if (flag == -1 && res > (Integer.MAX_VALUE - curNum)/10) {
                    return Integer.MIN_VALUE;
                } else if (flag == 1 && res > ((Integer.MAX_VALUE - curNum)/10)) {
                    return Integer.MAX_VALUE;
                }
                res *= 10;
                res += curNum;
                index++;
            } else {
                break;
            }
        }
        return res*flag;
    }

    public boolean isNumber(char c) {
        return c - '0' <= 9 && c - '0' >= 0;
    }
}
