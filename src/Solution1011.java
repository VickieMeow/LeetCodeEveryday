/**
 * 在D天内送达包裹的能力
 * 二分搜索的应用
 * @author miaomeiqi
 */
public class Solution1011 {

    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int left = 0, right = 1;
            for (int i = 0; i < weights.length; i++) {
                right += weights[i];
                left = Math.max(left, weights[i]);
            }
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (f(weights, mid) <= days) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        public int f(int[] weights, int x) {
            int temp = x;
            int days = 0;
            for (int i = 0; i < weights.length; ) {
                temp = x;
                while (i < weights.length) {
                    if (temp < weights[i]) {
                        break;
                    } else {
                        temp -= weights[i];
                    }
                    i++;
                }
                days++;
            }
            return days;
        }
    }
}
