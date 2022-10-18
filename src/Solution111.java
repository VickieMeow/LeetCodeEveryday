import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Solution111 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //1.递归
    public int minDepth1(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth1(root.left);
        int right = minDepth1(root.right);
        //如果节点没有左子树或者右子树，那么只考虑它存在的子树的深度
        return (left == 0 || right == 0) ? left+right+1:Math.min(left,right)+1;
    }

    //2.迭代-层序遍历
    public int minDepth2(TreeNode root) {
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        if(root == null) return 0;
        int curr_depth = 0;
        queue.offer(new Pair(root,1));
        while (!queue.isEmpty()) {
            Pair<TreeNode,Integer> currPair = queue.poll();
            TreeNode node = currPair.getKey();
            curr_depth = currPair.getValue();
            //迭代找每一层的叶子节点，遇到第一个叶子节点就返回
            if(node.left == null && node.right == null) break;
            if(node.left != null) queue.offer(new Pair(node.left,curr_depth+1));
            if(node.right != null) queue.offer(new Pair(node.right,curr_depth+1));
        }
        return curr_depth;
    }

}