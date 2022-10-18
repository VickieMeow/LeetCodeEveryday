import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution242 {

    //1.字符数组排序法
    //可以用String.valueOf函数，将数组转换为字符串
    //也可以调用Arrays静态equals方法比较两个字符串是否相等
    public boolean isAnagram1(String s, String t) {
        char[] s_chars = s.toCharArray();
        char[] t_chars = t.toCharArray();
        Arrays.sort(s_chars);
        Arrays.sort(t_chars);
        //s = String.valueOf(s_chars);
        //t = String.valueOf(t_chars);
        return Arrays.equals(s_chars,t_chars) ;
    }

    //2.哈希表法
    //时间复杂度还可以
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) return false;
        }
        return true;
    }


}