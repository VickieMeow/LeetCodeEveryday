public class Solution63 {
    //1.常规2维动态规划
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] res = new int[m][n];
        res[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for(int i = 1 ;i < n; i++) {
            res[0][i] = obstacleGrid[0][i] == 1 ? 0 : res[0][i - 1];
        }
        for(int i = 1; i < m; i++) {
            res[i][0] = obstacleGrid[i][0] == 1 ? 0 : res[i - 1][0];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                res[i][j] = obstacleGrid[i][j] == 1 ? 0 : res[i][j - 1] + res[i - 1][j];
            }
        }

        return res[m - 1][n - 1];
    }

    //2.动态规划-优化
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }





}
