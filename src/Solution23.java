import java.util.PriorityQueue;

/**
 * @author miaomeiqi
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1), p = dummy;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        for (ListNode node : lists) {
            if (node != null) {
                heap.add(node);
            }
        }
        while (!heap.isEmpty()) {
            ListNode curNode = heap.poll();
            p.next = curNode;
            p = p.next;
            if (curNode.next != null) {
                heap.add(curNode.next);
            }
        }
        return dummy.next;
    }


    class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }
}