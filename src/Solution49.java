import java.util.*;

public class Solution49 {
    //1.排序数组分类
    //时间复杂度为O(NKlogK)
    public List<List<String>> groupAnagrams1(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();
        Map<String,List> map = new HashMap<>();
        for(String str : strs) {
            char[] str_chars = str.toCharArray();
            Arrays.sort(str_chars);
            String key = String.valueOf(str_chars);
            if(!map.containsKey(key)) map.put(key,new ArrayList());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());//为什么不能加尖括号？
    }


    //2.字母计数法
    //时间复杂度较高
    public List<List<String>> groupAnagrams2 (String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String,List> map = new HashMap<>();
        int[] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count,0);
            for(char c :str.toCharArray()){
                count[c - 'a'] ++;
            }
            StringBuilder str_builder = new StringBuilder();
            for(int i = 0;i < count.length;i++){//用#分割因为每一个字母的count可能为两位数
                str_builder.append('#');
                str_builder.append(count[i]);
            }
            String key = str_builder.toString();
            if(!map.containsKey(key)) map.put(key,new ArrayList());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}
