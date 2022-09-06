import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 在每个树行中找最大值
 * @author miaomeiqi
 */
public class Solution515 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null) {
            return res;
        }
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            int curMaxNum = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode curNode = deque.pollFirst();
                if (curNode.left != null) {
                    deque.offer(curNode.left);
                }
                if (curNode.right != null) {
                    deque.offer(curNode.right);
                }
                curMaxNum = Math.max(curNode.val, curMaxNum);
            }
            res.add(curMaxNum);
        }
        return res;
    }
}
