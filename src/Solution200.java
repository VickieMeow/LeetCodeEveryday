import java.util.HashSet;

public class Solution200 {
    public static void main(String[] args) {
//        char[][] grid = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'}
//                ,{'0','0','0','1','1'}};
        char[][] grid = new char[][]{{'1'},{'1'}};
        Solution200 solution200 = new Solution200();
        System.out.println(solution200.numIslands(grid));
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        DisjointSet disjointSet = new DisjointSet(m*n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    disjointSet.parent[i*n+j] = i*n+j;
                } else {
                    disjointSet.parent[i*n+j] = -1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char curChar = grid[i][j];
                if (curChar == '1'&& i != m-1) {
                    char bottomChar = grid[i+1][j];
                    if (bottomChar == '1') {
                        disjointSet.joint(i*n+j, (i+1)*n+j);
                    }
                }
                if (curChar == '1' && j != n-1) {
                    char rightChar = grid[i][j+1];
                    if (rightChar == '1') {
                        disjointSet.joint(i*n+j, i*n+j+1);
                    }
                }

            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < disjointSet.parent.length; i++) {
            if (disjointSet.parent[i] != -1) {
                set.add(disjointSet.find(disjointSet.parent[i]));
            }
        }
        return set.size();
    }

    class DisjointSet {
        int[] parent;
        int[] rank;
        public DisjointSet(int N) {
            parent = new int[N];
            rank = new int[N];
        }
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public void joint(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) {
                return;
            }
            if (rank[x] == rank[y]) {
                parent[x] = y;
                rank[y]++;
            } else if (rank[x] > rank[y]) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }
}