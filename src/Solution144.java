import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution144 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }


    //1.递归
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }
    public void helper(TreeNode root,List<Integer> res) {
        if(root != null) {
            res.add(root.val);
            if(root.left != null) helper(root.left,res);
            if(root.right != null) helper(root.right,res);
        }
    }

    //2.栈
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode point = root;
        while (point != null || !stack.isEmpty()) {
            while (point != null){
                res.add(point.val);
                stack.push(point);
                point = point.left;
            }
            point = stack.pop().right;
        }
        return res;
    }





}
