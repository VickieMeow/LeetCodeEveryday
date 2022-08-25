import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 重复的DNA序列
 */
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


    /**
     * labuladong滑窗解法
     * 把字符串序列进行哈希处理，转换为int值，滑动窗口滑动时思想是每次给数字低位添加一个数字，最高位去掉一个数字
     */
    public List<String> findRepeatedDnaSequencesLabuladong(String s) {
        int[] nums = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'A':
                    nums[i] = 0;
                    break;
                case 'C':
                    nums[i] = 1;
                    break;
                case 'G':
                    nums[i] = 2;
                    break;
                case 'T':
                    nums[i] = 3;
                    break;
                default:
                    break;
            }
        }
        HashSet<Integer> seen = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        //数字位数
        int L = 10;
        //进制
        int R = 4;
        int RL = (int) Math.pow(R, L - 1);
        //滑动窗口中字符串的哈希值
        int windowHash = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            windowHash = windowHash * R + nums[right];
            right++;
            if (right - left == L) {
                if (seen.contains(windowHash)) {
                    res.add(s.substring(left, right));
                } else {
                    seen.add(windowHash);
                }
                windowHash = windowHash - nums[left] * RL;
                left++;
            }
        }
        return new ArrayList<>(res);

    }
}
