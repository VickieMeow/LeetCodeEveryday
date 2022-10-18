public class Solution191 {

    //1.右移判断1法
    //注意java这里有个坑,java没有无符号整型
    // 因此位运算时注意需要用逻辑移位>>>代替算数移位>>
    //逻辑右移高位补0，算数移位时如果是负数则高位补1，导致程序陷入死循环
    public int hammingWeight1(int n) {
        if(n == 0) return 0;
        int res = 0;
        while(n != 0){
            if((n & 1 ) == 1) res++;
            n >>>= 1;//java需要用>>>代替>>，不然会陷入死循环
        }
        return res;
    }

    //2.清零最低位的1法
    public int hammingWeight2(int n) {
        if(n == 0) return 0;
        int res = 0;
        while(n != 0){
            n &= (n - 1);
            res ++;
        }
        return res;
    }


}
