public class Offer22 {
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
