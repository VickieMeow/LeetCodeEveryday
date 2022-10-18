public class Solution367 {
    //1.二分查找
    public boolean isPerfectSquare1(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1;//mid必须为long或double类型，因为mid*mid有可能发生溢出使得low始终小于等于high，进而程序陷入死循环
            if (mid * mid == num)   return true;
            else if (mid * mid < num)  low = (int) mid + 1;
            else high = (int) mid - 1;
        }
        return false;
    }
    //2.等差数列法
    public boolean isPerfectSquare2(int num) {
        int i = 1;
        while(num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    //3.牛顿迭代法
    public boolean isPerfectSquare3(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }

}
