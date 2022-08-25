/**
 * 航班预订统计
 * 本质上是差分数组
 * @author miaomeiqi
 */
public class Solution1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        Difference difference = new Difference(res);
        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            difference.increment(i, j, val);
        }
        return difference.result();

    }

    class Difference {
        /**
         * 差分数组
         */
        private int[] diff;

        /**
         * 输入一个初始数组，区间操作将在这个数组上进行
         */
        public Difference(int[] nums) {
            assert nums.length > 0;
            diff = new int[nums.length];
            // 根据初始数组构造差分数组
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        /**
         * 给闭区间 [i, j] 增加 val（可以是负数）
         */
        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        /**
         * 返回结果数组
         */
        public int[] result() {
            int[] res = new int[diff.length];
            // 根据差分数组构造结果数组
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }
}
