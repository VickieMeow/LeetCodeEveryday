import algorithm.Difference;

/**
 * 区间加法
 * 假设有一个长度为n的数组，初始情况下所有数字均为0，将被给出K个更新的操作
 * 其中，每个操作会被表示为一个三元组[startIndex, endIndex, inc]，
 * 需要将子数组A[startIndex...endIndex]包括（startIndex和endIndex）增加inc
 * 返回k次操作后的数组
 *
 * input: length = 5, updates = [[1,3,2], [2,4,3], [0,2,-2]]
 * output:[-2,0,3,5,3]
 * @author miaomeiqi
 */
public class Solution370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        Difference df = new Difference(nums);
        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];
            int val = update[2];
            df.increment(i, j, val);
        }
        return df.result();
    }

}
