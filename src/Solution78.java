class Solution78 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }
    public void dfs(int[] nums, int curIndex) {
        if (curIndex == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[curIndex]);
        dfs(nums, curIndex+1);
        path.remove(path.size()-1);
        dfs(nums, curIndex+1);
    }
}