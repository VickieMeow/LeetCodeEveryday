/**
 * 二叉树展开为链表
 * 最开始思路是用一个Deque存每个先序遍历节点，之后再一个一个操作，需要遍历两次，性能太差
 * 之后看图发现可以分解子问题，每个root的结果都可以看做是 根-左子树结果-右子树结果 （其中"-"表示向右侧链接）
 * @author miaomeiqi
 */
public class Solution114 {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
    }

    ////////////第一版答案/////////////////

    public void flatten(TreeNode root) {
        flatten2(root);
    }
    public TreeNode flatten2(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            TreeNode right = root.right;
            TreeNode left = root.left;
            root.left = null;
            root.right = flatten2(left);
            TreeNode ptr = root;
            while (ptr.right != null) {
                ptr = ptr.right;
            }
            ptr.left = null;
            ptr.right = flatten2(right);
        }
        return root;
    }
    ////////////////////////////////////////////

    ///////////////参考答案////////////////////

    public void flatten3(TreeNode root) {
        if(root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null) {
            root = root.right;
        }
        root.right = tmp;
    }
    /////////////////////////////////////////


}
