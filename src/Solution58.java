public class Solution58 {
    //注意字符串前后空格处理
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0, index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        for (int i = index; i >= 0; i--) {
            if (s.charAt(i)==' ') {
                return res;
            } else {
                res++;
            }
        }
        return res;
    }
}