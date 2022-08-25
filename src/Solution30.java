import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution30 {
    /**
     * 朴素哈希表方法
     * out用法 hashmap可用equals比较
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> curMap = new HashMap<>();
        int wordNum = words.length;
        int w = words[0].length();
        int length = s.length();
        for (String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        out : for (int i = 0; i + w * wordNum < length; i++) {
            String subStr  = s.substring(i, i + wordNum * w);
            for (int j = 0; j < subStr.length(); j += w) {
                String curWord = subStr.substring(j, j+w);
                if (!map.containsKey(curWord)) {
                    continue out;
                }
                curMap.put(curWord, curMap.getOrDefault(curWord, 0) + 1);
            }
            if (map.equals(curMap)) {
                res.add(i);
            }
        }
        return res;
    }

    //滑动窗口优化
    //按照对单词长度取余来划分
    public List<Integer> findSubstring2(String s, String[] words) {
        int n = s.length(), m = words.length, w = words[0].length();
        // 统计 words 中「每个目标单词」的出现次数
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            // 构建一个当前子串对应 map，统计当前子串中「每个目标单词」的出现次数
            Map<String, Integer> curMap = new HashMap<>();
            // 滑动窗口的大小固定是 m * w
            // 每次将下一个单词添加进 cur，上一个单词移出 cur
            for (int j = i; j + w <= n; j += w) {
                String cur = s.substring(j, j + w);
                if (j >= i + (m * w)) {
                    int idx = j - m * w;
                    String prev = s.substring(idx, idx + w);
                    if (curMap.get(prev) == 1) curMap.remove(prev);
                    else curMap.put(prev, curMap.get(prev) - 1);
                }
                curMap.put(cur, curMap.getOrDefault(cur, 0) + 1);
                // 如果当前子串对应 map 和 words 中对应的 map 相同，说明当前子串包含了「所有的目标单词」，将起始下标假如结果集
                if (map.containsKey(cur) && curMap.get(cur).equals(map.get(cur)) && curMap.equals(map)) {
                    ans.add(j - (m - 1) * w);
                }
            }
        }
        return ans;
    }
}
