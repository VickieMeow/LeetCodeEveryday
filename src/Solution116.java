import java.util.ArrayDeque;
import java.util.Deque;

/**
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
}
