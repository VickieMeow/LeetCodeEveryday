public class Solution45 {
    //1.贪心算法
    //每次都选择可跳范围内结点跳的最远的
    //curEnd为当前确定跳到的边界
    //currFarthest为可跳到的最远的地方
    //题目中假定一定能跳到最后
    //时间复杂度为O(N)
    public int jump1(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
    //2.BFS-解释贪心算法
    //按层考虑，第i层表示经过i跳可到达的节点
    public int jump2(int[] nums) {
        if(nums.length <= 1) return 0;
        int curMax = 0;//记录某层的最后一个元素下标
        int level = 0,i = 0;
        while(i <= curMax){
            int furthest = curMax;
            for(;i<=curMax;i++){
                furthest = Math.max(furthest,nums[i]+i);
                if(furthest >= nums.length-1) return level+1;
            }
            curMax = furthest;
            level++;
        }
        return level;
    }

}
