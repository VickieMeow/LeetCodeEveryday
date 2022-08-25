import java.util.LinkedList;
import java.util.Queue;

public class Offer4 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        //int[][] matrix = new int[][]{{1},{1}};
        //int[][] matrix = new int[][]{{1,3,5}};
        int target = 30;
        Offer4 offer4 = new Offer4();
        System.out.println(offer4.findNumberIn2DArray(matrix, target));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length-1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                j--;
                continue;
            }
            if (matrix[i][j] < target) {
                i++;
                continue;
            }
        }
        return false;
    }
}
