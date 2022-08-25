import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口问题
 * 类比76题
 * @author miaomeiqi
 */
public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char ch = s2.charAt(right);
            right++;
            if (need.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (need.get(ch).equals(window.get(ch))) {
                    valid++;
                }
            }
            while (right - left >= s1.length()) {
                if (valid == need.keySet().size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    //这里一定要用equals 比较Integer
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
