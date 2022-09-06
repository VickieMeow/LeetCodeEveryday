/**
 * 翻转二叉树
 * @author miaomeiqi
 */
public class Solution226 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftRoot = invertTree(root.left);
        TreeNode rightRoot = invertTree(root.right);
        root.left = rightRoot;
        root.right = leftRoot;
        return root;
    }
}
