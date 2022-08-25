import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * 主要思想，设置上下左右四个边界，注意循环遍历的时候，用if判断
 * @author miaomeiqi
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int topBound = 0, bottomBound = m-1, leftBound = 0, rightBound = n-1;
        while (res.size() < m*n) {
            if (topBound <= bottomBound) {
                for (int j = leftBound; j <= rightBound; j++) {
                    res.add(matrix[topBound][j]);
                }
                topBound++;
            }
            if (leftBound <= rightBound) {
                for (int i = topBound; i <= bottomBound; i++) {
                    res.add(matrix[i][rightBound]);
                }
                rightBound--;
            }
            if (topBound <= bottomBound) {
                for (int j = rightBound; j >= leftBound; j--) {
                    res.add(matrix[bottomBound][j]);
                }
                bottomBound--;
            }
            if (leftBound <= rightBound) {
                for (int i = bottomBound; i >= topBound; i--) {
                    res.add(matrix[i][leftBound]);
                }
                leftBound++;
            }
        }
        return res;
    }
}
