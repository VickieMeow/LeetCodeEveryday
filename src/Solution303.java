/**
 * 前缀和计算问题
 * @author miaomeiqi
 */
public class Solution303 {
    class NumArray {
        int[] prefixSum;
        int n;

        public NumArray(int[] nums) {
            n = nums.length;
            prefixSum = new int[n+1];
            for (int i = 1; i <= n; i++) {
                prefixSum[i] = prefixSum[i-1] + nums[i-1];
            }
        }

        public int sumRange(int left, int right) {
            return prefixSum[right+1] - prefixSum[left];
        }
    }
}
