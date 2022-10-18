import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    //1.暴力法
    public int[] twoSum1(int[] nums, int target) {
        int[]result = new int[2];
        for(int i=0;i<nums.length-1;i++){
            for (int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target) {
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
    }

    //2.两遍hash表
    //先存后查
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //3.一遍哈希表法
    //边存边查
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<nums.length;i++){
            if(map.containsKey(target-nums[i]) && map.get(target-nums[i])!= i)
                return new int[]{i,map.get(target-nums[i])};
            map.put(nums[i],i);
        }
        return null;
    }









}
