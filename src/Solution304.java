/**
 * 二维区域和检索 思想和Solution303一致 都是前缀和
 * 前缀和数组的prefixSum[i][j]对应到不包含matrix[i][j]的值
 * prefixSum[i+1][j+1]才对应包含matrix[i][j]的区域
 * @author miaomeiqi
 */
public class Solution304 {
    class NumMatrix {
        int rowNum;
        int colNum;
        int[][] prefixSum;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            int rowNum = matrix.length;
            int colNum = matrix[0].length;
            prefixSum = new int[rowNum+1][colNum+1];
            for (int i = 1; i <= rowNum; i++) {
                for (int j = 1; j <= colNum; j++) {
                    prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] + matrix[i-1][j-1] - prefixSum[i-1][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return prefixSum[row2+1][col2+1] - prefixSum[row1][col2+1] - prefixSum[row2+1][col1] + prefixSum[row1][col1];
        }
    }
}
