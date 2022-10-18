import org.w3c.dom.ls.LSException;

import java.util.*;

public class Solution_15 {

    //1.双指针法
    //双指针法使用的前提是数组必须为排好序的，给定数组先排序，固定最小指针k
    //i和j分别在k右侧的两端移动
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k + 1]) continue;

            int i = k + 1, j = nums.length - 1;
            int sum = nums[k] + nums[i] + nums[j];
            if (sum < 0) {
                while (i < j && nums[i] == nums[++i]) ;
            } else if (sum > 0) {
                while (i < j && nums[j] == nums[--j]) ;
            } else if (sum == 0) {
                res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                while (i < j && nums[i] == nums[++i]) ;
                while (i < j && nums[j] == nums[--j]) ;
            }
        }
        return res;
    }




}
