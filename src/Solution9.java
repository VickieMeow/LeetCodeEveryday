public class Solution9 {
    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        System.out.println(solution9.isPalindrome(12321));
    }
    public boolean isPalindrome(int x) {
        int tempNum = x;
        int res = 0;
        while (tempNum != 0) {
            res *= 10;
            int curNum = tempNum % 10;
            res += curNum;
            tempNum /= 10;
        }
        return res == x;
    }
}
