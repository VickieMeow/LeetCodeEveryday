import java.util.ArrayList;
import java.util.List;

class Solution526 {

    public static void main(String[] args) {
        Solution526 solution526 = new Solution526();
    }
    int res;

    public int countArrangement(int n) {
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[n+1];
        dfs(path, n, used);
        return n;
    }

    public void dfs(List<Integer> path, int n, boolean[] used) {
        if (path.size() == n) {
            res++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!used[i] &&
                    (i % (path.size() + 1) == 0 || (path.size() + 1) % i == 0)) {
                path.add(i);
                used[i] = true;
                dfs(path, n, used);
                path.remove(path.size() - 1);
                used[i] = false;
            } else {
                continue;
            }
        }
    }
}