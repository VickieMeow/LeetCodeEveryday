import java.util.Random;

/**
 * 按权重随机选择
 * @author miaomeiqi
 */
public class Solution528 {
    class Solution {
        private int[] preSum;
        private Random random = new Random();

        public Solution(int[] w) {
            int n = w.length;
            preSum = new int[n+1];
            preSum[0] = 0;
            for (int i = 1; i <=n ; i++) {
                preSum[i] = preSum[i-1] + w[i-1];
            }
        }

        public int pickIndex() {
            int n = preSum.length;
            int target = random.nextInt(preSum[n-1]) + 1;
            return binarySearchLeftBoundary(preSum, target) - 1;
        }

        /**
         * 二分搜索左边界
         * 找到大于等于target的最小元素索引
         */
        public int binarySearchLeftBoundary(int[] w, int target) {
            int left = 0, right = w.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (w[mid] == target) {
                    right = mid - 1;
                } else if (w[mid] > target) {
                    right = mid - 1;
                } else if (w[mid] < target) {
                    left = mid + 1;
                }
            }
            return right + 1;
        }
    }
}
