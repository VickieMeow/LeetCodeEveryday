import java.util.HashMap;

/**
 * 从前序与中序遍历序列构造二叉树
 * @author miaomeiqi
 */
public class Solution105 {
    HashMap<Integer, Integer> map = new HashMap<>();
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }

    public TreeNode helper(int[] preorder, int preStartIndex, int preEndIndex,
                           int[] inorder, int inStartIndex, int inEndIndex) {
        if (preStartIndex > preEndIndex || inStartIndex > inEndIndex) {
            return null;
        }
        TreeNode root = null;
        int rootVal = preorder[preStartIndex];
        // 优化了一下，因为Key没有重复的，所以这里可以直接用hashmap来保存值和下标的映射
        int rootIndexInInOrder = map.get(rootVal);
        if (rootIndexInInOrder != -1) {
            int leftNodeNum = rootIndexInInOrder - inStartIndex;
            int rightNodeNum = inEndIndex - rootIndexInInOrder;
            root = new TreeNode(rootVal);
            TreeNode leftTree = helper(preorder, preStartIndex+1, preStartIndex+leftNodeNum,
                    inorder, inStartIndex, rootIndexInInOrder - 1);
            TreeNode rightTree = helper(preorder, preStartIndex+leftNodeNum+1, preEndIndex,
                    inorder, rootIndexInInOrder+1, inEndIndex);
            root.left = leftTree;
            root.right = rightTree;
        }
        return root;
    }

    public int findCertainNumIndex(int[] arr, int num, int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }
}
