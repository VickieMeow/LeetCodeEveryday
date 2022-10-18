import java.util.ArrayList;
import java.util.List;

public class Solution131 {

    public static void main(String[] args) {
        String s = "aab";
        Solution131 solution131 = new Solution131();
        System.out.println(solution131.partition(s));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> solution = new ArrayList<>();
        if (s.length() == 1) {
            solution.add(s);
            res.add(solution);
            return res;
        }
        for (int i = 1; i < s.length(); i++) {
            String curStr = s.substring(0, i);
            if (isParidrom(curStr)) {
                List<List<String>> lastRes = partition(s.substring(i));
                for (List<String> list: lastRes) {
                    list.add(curStr);
                    res.add(list);
                }
            } else {
                continue;
            }
        }
        return res;
    }
    public boolean isParidrom(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        int i = 0;
        int j = s.length()-1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}