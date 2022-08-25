/**
 * 螺旋矩阵 思想同T54，这里注意判断条件是n*n
 * @author miaomeiqi
 */
public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int number = 1;
        int topBound = 0, bottomBound = n-1, leftBound = 0, rightBound = n-1;
        while (number <= n*n) {
            if (topBound <= bottomBound) {
                for (int j = leftBound; j <= rightBound; j++) {
                    res[topBound][j] = number;
                    number++;
                }
                topBound++;
            }
            if (leftBound <= rightBound) {
                for (int i = topBound; i <= bottomBound; i++) {
                    res[i][rightBound] = number;
                    number++;
                }
                rightBound--;
            }
            if (topBound <= bottomBound) {
                for (int j = rightBound; j >= leftBound; j--) {
                    res[bottomBound][j] = number;
                    number++;
                }
                bottomBound--;
            }
            if (leftBound <= rightBound) {
                for (int i = bottomBound; i >= topBound; i--) {
                    res[i][leftBound] = number;
                    number++;
                }
                leftBound++;
            }
        }
        return res;
    }
}