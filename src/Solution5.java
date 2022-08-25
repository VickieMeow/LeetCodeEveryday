import java.util.HashMap;
import java.util.Map;

public class Solution5 {


    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestPalindrome("abccbsasdc"));
    }

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int len = 2; len <= s.length(); len++) {
            for (int i = 0; i < s.length() - 1; i++) {
                int j = i + len - 1;
                if (j >= s.length()) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (len <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                    if (dp[i][j] && len > maxLen) {
                        start = i;
                        maxLen = len;
                    }
                }

            }
        }
        return s.substring(start, start+maxLen);
    }

    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    /**
     * labuladong的双指针中心扩散法
     * 题目可抽象为，对于每一个i（0<=i<s.length()）
     * 分别求以i为中心的最大回文串和以i,i+1为中心的最大回文串
     */
    public String longestPalindrome_labuladong(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = findPalindrome(s, i, i);
            String s2 = findPalindrome(s, i, i+1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    /**
     * 返回字符串s中以l和r为中心的最大回文串
     */
    public String findPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }



}
