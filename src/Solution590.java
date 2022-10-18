import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution590 {
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
    public List<Integer> postorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }
    public void helper(Node root,List<Integer> res){
        if(root == null) return;
        for(Node node : root.children){
            helper(node,res);
        }
        res.add(root.val);
    }

    //2.迭代方法
    //栈翻转一次，Collections.reverse翻转一次
    public List<Integer> postorder2(Node root) {
        if(root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            for(Node node : root.children) stack.add(node);
        }
        Collections.reverse(res);
        return res;
    }






}
