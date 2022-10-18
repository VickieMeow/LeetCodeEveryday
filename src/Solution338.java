public class Solution338 {

    //1.暴力计算法
    //不管哪种情况都清零最低位1计算
    public int[] countBits1(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; ++i)
            ans[i] = popcount(i);
        return ans;
    }
    private int popcount(int x) {
        int count;
        for (count = 0; x != 0; ++count)
            x &= x - 1; //zeroing out the least significant nonzero bit
        return count;
    }

    //2.动态规划+最高有效位
    //假设有一个整数： x = 605 = 1001011101
    //我们已经计算了从 0 到 x - 1 的全部结果
    //我们知道，x与我们计算过的一个数只有一位之差： _x = 93 = 1011101
    //它们只在最高有效位上不同，它们的 pop count 只相差1
    //总之，对于 pop count P(x)有如下状态转移函数：
    // P(x + b) = P(x) + 1, b = 2^m > x
    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        int i = 0, b = 1;
        // [0, b) is calculated
        while (b <= num) {
            // generate [b, 2b) or [b, num) from [0, b)
            while(i < b && i + b <= num){
                ans[i + b] = ans[i] + 1;
                ++i;
            }
            i = 0;   // reset i
            b <<= 1; // b = 2b
        }
        return ans;
    }

    //3.动态规划+最低有效位
    // x = 605 = 1001011101
    // _x = 302 = 100101110
    //类似上一个方法，x和_x只差了一个有效位，且_x小于x
    // _x可以看作是x移除最低有效位的结果
    //故状态转移函数为：
    // P(x) = P(x / 2) + (x mod 2)
    public int[] countBits3(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
        return ans;
    }

    //4.动态规划+最后设置位
    //与上述思路相同，可利用 x &= x - 1 将该位设置为0，得到状态转移函数：
    // P(x) = P(x & (x - 1)) + 1
    public int[] countBits4(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i & (i - 1)] + 1;
        return ans;
    }












}
