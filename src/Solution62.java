import java.util.Arrays;

public class Solution62 {

    //1.动态规划解法1
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0;i < n;i++) dp[0][i] = 1;
        for(int i = 0;i < m;i++) dp[i][0] = 1;
        for(int i = 1;i < m;i++) {
            for(int j = 1;j < n;j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


    //2.空间优化
    //只需要存储上一行的数值就可以了，因此一个数组足够了
    //最佳解法
    public int uniquePath2(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);

        for(int i = 1; i < m; i ++) {
            for(int j = 1;j < n;j ++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }

}
