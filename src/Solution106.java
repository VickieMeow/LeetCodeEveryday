import java.util.HashMap;

/**
 * 从中序与后序遍历序列构造二叉树
 * @author miaomeiqi
 */
public class Solution106 {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode res = helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
        return res;
    }

    public TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        TreeNode root = null;
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        int rootIndex = map.get(rootVal);
        int leftCount = rootIndex - inStart;
        int rightCount = inEnd - rootIndex;
        root = new TreeNode(rootVal);
        TreeNode left = helper(inorder, inStart, rootIndex-1, postorder, postStart, postStart+leftCount - 1);
        TreeNode right = helper(inorder, rootIndex+1, inEnd, postorder, postStart+leftCount, postStart+leftCount+rightCount-1);
        root.left = left;
        root.right = right;
        return root;
    }
}
