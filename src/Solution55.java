public class Solution55 {
    //1.贪心
    // 从后往前递推
    public boolean canJump1(int[] nums) {
        if(nums == null || nums.length == 1) return true;
        int pos = nums.length - 1;
        for(int i = nums.length - 2;i >= 0;i --) {
            if(nums[i]+i >= pos) pos = i;
        }
        return pos == 0;
    }

    //2.从前往后递推
    public boolean canJump2(int[] A) {
        int reachable = 0;
        for(int i = 0;i < A.length;i++) {
            if(i > reachable) return false;
            reachable = Math.max(A[i] + i,reachable);
        }
        return true;
    }

}
