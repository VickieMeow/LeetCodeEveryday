import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution102 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //1.广度优先层序遍历
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            while (size -- > 0){
                TreeNode currNode = queue.poll();
                currLevel.add(currNode.val);
                if(currNode.left != null) queue.offer(currNode.left);
                if(currNode.right != null) queue.offer(currNode.right);
            }
            ans.add(currLevel);
        }
        return ans;
    }

    //2.深度优先递归遍历
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        helper(root,0,ans);
        return ans;
    }
    public void helper(TreeNode node,int level,List<List<Integer>> ans) {
        if(node == null) return;
        if(ans.size() == level) ans.add(new ArrayList<>());
        ans.get(level).add(node.val);
        helper(node.left,level+1,ans);
        helper(node.right,level+1,ans);
    }




}
