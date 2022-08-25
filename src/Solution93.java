import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author miaomeiqi
 */
public class Solution93 {

    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    /**
     * 在s中插入三个点
     * 分割开的数字在0~255区间
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        char[] nums = s.toCharArray();
        int pointCount = 3;
        int numLen = s.length() / 4; // 每个位置最少有几个数字
        int extarNum = s.length() % 4;
        return null;
    }

    public void findIpAddress(int index, char[] nums, int pointCount, StringBuilder path) {
        if (pointCount == 0 || index == nums.length) {
            res.add(path.toString());
            return;
        }


    }

}


class Solution {

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len > 12 || len < 4) {
            return res;
        }

        Deque<String> path = new ArrayDeque<>(4);
        dfs(s, len, 0, 4, path, res);
        return res;
    }

    // 需要一个变量记录剩余多少段还没被分割

    private void dfs(String s, int len, int begin, int residue, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (residue == 0) {
                res.add(String.join(".", path));
            }
            return;
        }

        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) {
                break;
            }

            if (residue * 3 < len - i) {
                continue;
            }

            if (judgeIpSegment(s, begin, i)) {
                String currentIpSegment = s.substring(begin, i + 1);
                path.addLast(currentIpSegment);

                dfs(s, len, i + 1, residue - 1, path, res);
                path.removeLast();
            }
        }
    }

    private boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }

        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }

        return res >= 0 && res <= 255;
    }
}




