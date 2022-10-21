public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        int depth = 0;
        boolean[] used = new boolean[nums.length];
        dfs(res, nums, depth, path, used);
        return res;
    }


    public void dfs(List<List<Integer>> res, int[] nums, int depth, Deque<Integer> path, boolean[] used) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(res, nums, depth+1, path, used);
            path.removeLast();
            used[i] = false;
        }
    }
}