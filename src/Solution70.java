//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划

public class Solution70 {

    //1.维护三个变量
    public int climbStairs1(int n) {
        if(n <= 3) return n;
        int f1 = 1 , f2 = 2 , f3 = 3;
        for(int i = 3;i < n + 1;i ++){
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    //2.使用数组缓存
    public int climbStairs2(int n) {
        if(n<3) return n;
        int[] a = new int[n+1];
        a[1]=1;a[2]=2;
        for(int i = 3;i <n+1;i++){
            a[i] = a[i-1] + a[i-2];
        }
        return a[n];
    }

    //3.Binets方法
    //使用矩阵相乘得到结果
    public int climbStairs3(int n) {
        int[][] q = {{1,1},{1,0}};
        int[][] res = pow(q,n);
        return res[0][0];

    }

    public int[][] pow(int[][]a,int n){
        int[][] ret = {{1,1},{1,0}};
        while (n > 0){
            if ( (n & 1) == 1){//注意一定要加小括号
                ret = multiply(a,ret);
            }
            n >>= 1;
            a = multiply(a,a);
        }
        return ret;
    }

    public int[][] multiply(int[][]a,int[][]b){
        int[][]c = new int[2][2];
        for(int i = 0;i < 2;i++){
            for(int j = 0;j < 2;j++){
                c[i][j] = a[i][0]*b[0][j]+a[i][1]*b[1][j];
            }
        }
        return c;
    }


}


