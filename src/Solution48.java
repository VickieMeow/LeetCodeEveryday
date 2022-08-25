
/**
 * 旋转图像
 * @author miaomeiqi
 */
public class Solution48 {

    /**
     * 每列翻转，之后沿对角线翻转，沿对角线翻转时，注意j的判断条件
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        //每列翻转，再沿对角线翻转
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[m-1-j][i];
                matrix[m-1-j][i] = temp;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}

