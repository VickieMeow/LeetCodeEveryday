public class Solution77 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, res, path, 1);
        return res;
    }

    public void dfs(int n, int k, List<List<Integer>> res, List<Integer> path, int depth) {
        if (path.size() == k) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        if (path.size() + n - depth + 1 < k) {
            return;
        }
        if (depth >= n+1) {
            return;
        }
        path.add(depth);
        dfs(n, k, res, path, depth+1);
        path.remove(path.size()-1);
        dfs(n, k, res, path, depth+1);
    }
}