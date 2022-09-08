/**
 * 最大二叉树
 * @author miaomeiqi
 */
public class Solution654 {
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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int startIndex, int endIndex) {
        int index = findIndexOfMaxNum(nums, startIndex, endIndex);
        TreeNode root = null;
        if (index != -1) {
            root = new TreeNode(nums[index]);
            root.left = helper(nums, startIndex, index-1);
            root.right = helper(nums, index+1, endIndex);
        }
        return root;
    }

    public int findIndexOfMaxNum(int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }
        int res = -1;
        int curNum = Integer.MIN_VALUE;
        for (int i = startIndex; i <= endIndex; i++) {
            if (nums[i] > curNum) {
                curNum = nums[i];
                res = i;
            }
        }
        return res;
    }
}
