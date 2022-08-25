import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution187 {
    public static void main(String[] args) {
        Solution187 solution187 = new Solution187();
        System.out.println(solution187.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
    List<String> res = new ArrayList<>();
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return res;
        }
        HashSet<String> stringHashSet = new HashSet<>();
        int endIndex = s.length();
        int startIndex = s.length() - 10;

        while (startIndex >= 0) {
            String curStr = s.substring(startIndex, endIndex);
            if (stringHashSet.contains(curStr)) {
                res.add(curStr);
            } else {
                stringHashSet.add(curStr);
            }
            startIndex--;
            endIndex--;
        }

        //res.addAll(stringHashSet);

        return res;
    }
}
