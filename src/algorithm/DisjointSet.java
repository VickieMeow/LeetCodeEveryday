package package2;

public class DisjointSet {
    private static final int N = 10;
    int[] parent = new int[N];
    int[] rank = new int[N];

    //查找x
    private int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    //合并两个集合 0-x,y已经在一个集合中  1-合并成功
    private int join(int x, int y) {
        x = this.find(x);
        y = this.find(y);
        if (x == y) {
            return 0;
        }
        // 让低的指向高的
        if (rank[x] > rank[y]) {
            parent[y] = x;
        } else if (rank[x] < rank[y]) {
            parent[x] = y;
        } else {
            parent[x] = y;
            rank[y]++;
        }
        return 1;
    }

    public static void main(String[] args) {
        DisjointSet disjointSet = new DisjointSet();
        disjointSet.parent = new int[N];
        disjointSet.rank = new int[N];
        // 初始化
        for (int i = 0; i < N; i++) {
            disjointSet.parent[i] = i;
        }
        int[][] edges = {{0,1},{1,2},{2,3},{4,5},{5,6},{1,4},{1,6}};
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if (disjointSet.join(x, y) == 0) {
                System.out.println("存在环");
                return;
            }
        }
        System.out.println("不存在环");
    }
}
