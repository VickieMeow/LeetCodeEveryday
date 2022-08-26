package algorithm;


/**
 * 二分查找应用模板
 * @author miaomeiqi
 */
public class BinarySearchInUse {
    /**
     * 函数f是关于自变量x的单调函数
     * @param x 自变量
     */
    int f(int x) {
        //
        return 0;
    }

    /**
     * 主函数，在f(x) == target的约束下求x的最值
     */
    int solution(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left;// = ...;
        int right; //= ... + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(mid) == target) {
                //问自己：题目是求左边界还是右边界？
                //...
            } else if (f(mid) < target) {
                //问自己：怎么让f(x)大一点？
                // ...
            } else if (f(mid) > target) {
                //问自己：怎么让f(x)小一点？
                //...
            }
        }
        return left;
    }

}
