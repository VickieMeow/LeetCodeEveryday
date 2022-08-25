/**
 * @author miaomeiqi
 */
public class Solution97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1; i < m+1 && s1.substring(0,i+1).equals(s3.substring(0,i+1)); i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < n+1 && s2.substring(0,j+1).equals(s3.substring(0,j+1)); j++) {
            dp[0][j] = true;
        }

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }
        return dp[m][n];

    }
}
