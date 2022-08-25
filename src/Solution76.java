import java.util.*;

/**
 * 最小覆盖子串
 * 滑窗问题
 * @author miaomeiqi
 */
public class Solution76 {
    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public String minWindow2(String s, String t) {
        char[] chars = s.toCharArray(), chart = t.toCharArray();
        int n = chars.length, m = chart.length;

        int[] hash = new int[128];
        for (char ch : chart) {
            hash[ch]--;
        }

        String res = "";
        // i为右指针，j为左指针
        for (int i = 0, j = 0, cnt = 0; i < n; i++) {
            hash[chars[i]]++;
            if (hash[chars[i]] <= 0) {
                //如果t包含这个字符才需要给cnt加一
                cnt++;
            }
            while (cnt == m && hash[chars[j]] > 0) {
                hash[chars[j++]]--;
            }
            if (cnt == m) {
                if ("".equals(res) || res.length() > i - j + 1) {
                    res = s.substring(j, i + 1);
                }
            }
        }
        return res;
    }

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        for (Map.Entry<Character, Integer> characterIntegerEntry : ori.entrySet()) {
            Character key = (Character) ((Map.Entry<?, ?>) characterIntegerEntry).getKey();
            Integer val = (Integer) ((Map.Entry<?, ?>) characterIntegerEntry).getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }


    /**
     * 滑动窗口 labuladong解法 配合SlidingWindow模板看
     * 注意两个hashmap，判断条件是字符对应的个数相等，就是value相等 valid才能++
     */
    public String minWindowLabuladong(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        // valid表示窗口中满足need条件的字符个数，如果valid == need.keyset.size 那么窗口就满足了条件
        int valid = 0;
        // 记录最小子串起始位置下标和长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            //判断左窗口是否要收缩
            while (valid == need.keySet().size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (window.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }

}

