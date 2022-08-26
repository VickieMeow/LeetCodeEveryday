/**
 * 爱吃香蕉的珂珂
 * 二分搜索的应用，待求变量设为x，约束条件为h，f(x)为单调函数，抽象为二分搜索，在f(x)域中搜索target=h的x值
 * 框架模板见BinarySearchInUse
 * @author miaomeiqi
 */
public class Solution875 {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1000000000 + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int f(int[] piles, int k) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += piles[i] / k;
            if (piles[i] % k > 0) {
                hours ++;
            }
        }
        return hours;
    }
}
