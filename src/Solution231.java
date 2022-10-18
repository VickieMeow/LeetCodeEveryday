public class Solution231 {


    //1.判断n的二进制表示中1的个数
    //若一个数为2的幂，则其二进制表示中1的个数必为1
    public boolean isPowerOfTwo1(int n) {
        int res = 0;
        while(n != 0) {
            if( (n & 1) == 1 ) res++;
            n >>= 1;
        }
        return res == 1;
    }

    //2.直接打掉最后一个1
    //判断将n的二进制表示中最后一个1清零后是否等于0
    public boolean isPowerOfTwo2(int n) {
        if(n <= 0) return  false;
        return (n & (n - 1)) == 0;
    }


}
