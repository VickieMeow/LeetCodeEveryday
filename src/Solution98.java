import java.util.ArrayList;
import java.util.Stack;

public class Solution98 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //1.中序遍历法
    //时间复杂度为O(N)
    //递归中序遍历该二叉树，得到的数列如果满足递增就返回true
    public boolean isValidBST1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        midOrderTraverse(root,res);
        for(int i = 0;i < res.size() -1 ;i++) {
            if(res.get(i) >= res.get(i+1)) return false;//ArrayList的get方法可以这么用
        }
        return true;
    }
    public void midOrderTraverse(TreeNode root, ArrayList<Integer> res) {
        if(root == null) return;
        midOrderTraverse(root.left,res);
        res.add(root.val);
        midOrderTraverse(root.right,res);
    }

    //2.中序遍历法2
    public boolean isValidBST2(TreeNode root) {
        double inorder = - Double.MAX_VALUE;//有可能为负数
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    //3.递归法
    //时间复杂度为O(N)
    //判断当前节点是否小于上限，且大于下限
    //再递归判断它的子结点是否满足这个条件
    //注：根节点无下限上限，因为左右子树均可扩展啊
    public boolean isValidBST3(TreeNode root) {
        return helper(root,null,null);
    }
    public boolean helper(TreeNode root,Integer lower,Integer upper) {
        if(root == null) return true;
        int val = root.val;
        if(lower != null && val <= lower) return false;
        if(upper != null && val >= upper) return false;
        if(!helper(root.right,val,upper)) return false;
        if(!helper(root.left,lower,val)) return false;
        return true;
    }



}
