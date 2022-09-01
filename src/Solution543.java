import javax.swing.tree.TreeNode;

/**
 * 二叉树的直径
 * @author miaomeiqi
 */
public class Solution543 {
    int resDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth(root);
        return resDiameter;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        resDiameter = Math.max(leftDepth + rightDepth, resDiameter);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
    }
}
