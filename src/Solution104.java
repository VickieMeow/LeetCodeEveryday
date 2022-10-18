import java.util.LinkedList;
import java.util.Queue;

public class Solution104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //1.递归
    //最优解
    public int maxDepth1(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth1(root.left),maxDepth1(root.right)) + 1;
    }

    //2.层序遍历
    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- > 0) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            count ++;
        }
        return count;
    }

}
