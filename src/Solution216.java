import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution216 {
    public static void main(String[] args) {
        Solution216 solution216 = new Solution216();
        System.out.println(solution216.combinationSum3(3,7));
    }
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();


    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k > n) {
            return res;
        }
        if (45  < n) {
            return res;
        }
        dfs(res, path, k, n, 1);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> path, int k, int n, int curnum) {
        if (n == 0 && path.size() == k) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = curnum; i <= 9; i++) {
            path.add(i);
            dfs(res, path, k, n-i, i+1);
            path.remove(path.size()-1);
        }
    }

}