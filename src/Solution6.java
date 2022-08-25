public class Solution6 {
    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        System.out.println(solution6.convert("PAYPALISHIRING", 4));
        //"PAHNAPLSIIGYIR"
    }
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int part = numRows + numRows - 2;
        char[][] grid = new char[numRows][(numRows - 1) * (s.length()/part + 1)];
        int row = 0;
        int col = 0;
        for (int i = 0; i < s.length(); i++) {
            if (row < grid.length && col < grid[0].length) {
                grid[row][col] = s.charAt(i);
            }
            if (col % (numRows - 1) == 0 && (row < numRows - 1)) {
                row++;
            } else {
                row--;
                col++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sb.append(grid[i][j]);
            }
        }
        return sb.toString();
    }
}
