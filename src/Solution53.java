public class Solution_53 {

    //1.动态规划
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int max = 0;
        int res = nums[0];
        for(int i = 0;i < nums.length; i++) {
            max = Math.max(max + nums[i], nums[i]);//求数组中每一个元素之前的最大子序和
            res = Math.max(max, res);//更新，暂存当前结果
        }
        return res;
    }

    //2.分治法？？


}
