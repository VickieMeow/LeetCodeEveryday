/**
 * 二叉树中的最大路径和
 * @author miaomeiqi
 */
public class Solution124 {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        res = root.val;
        maxSidePathSum(root);
        return res;
    }


    /**
     * 对于root来说，返回单边最大值
     */
    public int maxSidePathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSideSum = Math.max(maxSidePathSum(root.left), 0);
        int rightSideSum = Math.max(maxSidePathSum(root.right), 0);
        res = Math.max(res, leftSideSum + rightSideSum + root.val);

        return root.val + Math.max(leftSideSum, rightSideSum);
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}
