import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 填充每一个节点的下一个节点指针
 * @author miaomeiqi
 */
public class Solution116 {
    class Node {
        Node left;
        Node right;
        Node next;
    }
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node curNode = deque.pollFirst();
                if (i != size - 1) {
                    curNode.next = deque.peekFirst();
                } else {
                    curNode.next = null;
                }
                if (curNode.left != null) {
                    deque.offer(curNode.left);
                }
                if (curNode.right != null) {
                    deque.offer(curNode.right);
                }
            }
        }

        return root;
    }


    /**
     * 另一种解法，把二叉树看做三叉树，中间连起来
     */
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        traverse(root.left, root.right);
        return root;
    }
    public void traverse(Node root1, Node root2) {
        if (root1 == null || root2 == null) {
            return;
        }
        root1.next = root2;
        traverse(root1.left, root1.right);
        traverse(root2.left, root2.right);
        traverse(root1.right, root2.left);
    }
}
