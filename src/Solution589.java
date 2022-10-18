import java.util.*;

public class Solution589 {
    class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    //1.递归方法
    public List<Integer> preorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }
    public void helper(Node root,List<Integer> res) {
        if(root == null) return;
        res.add(root.val);
        for(Node node : root.children) helper(node,res);
    }

    //2.迭代方法
    public List<Integer> preorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--)
                stack.add(root.children.get(i));
        }
        return res;
    }



}
