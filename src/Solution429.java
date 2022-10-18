import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_429 {
    class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    //1.迭代-借助队列
    public List<List<Integer>> levelOrder1(Node root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int length = queue.size();
            for(int i = 0;i < length;i ++) {
                Node curr = queue.poll();
                curLevel.add(curr.val);
                for(Node node : curr.children) queue.offer(node);
            }
            res.add(curLevel);
        }
        return res;
    }

    //2.递归
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root,0,res);
        return res;
    }
    public void dfs(Node root,int level,List<List<Integer>> res) {
        if(root == null) return;
        List<Integer> list = new ArrayList<>();
        if(level < res.size()) {
            list = res.get(level);
            list.add(root.val);
        }
        else {
            list.add(root.val);
            res.add(list);
        }
        for(Node node : root.children) dfs(node,level+1,res);
    }







}
