public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1), p1 = dummy1;
        ListNode dummy2 = new ListNode(-1), p2 = dummy2;
        ListNode p = head;
        while (p != null) {
            if (head.val < x) {
                p1.next = head;
                p = head.next;
                head.next = null;
                head = p;
                p1 = p1.next;
            } else {
                p2.next = head;
                p = head.next;
                head.next = null;
                head = p;
                p2 = p2.next;
            }
        }
        p1.next = dummy2.next;
        dummy2.next = null;
        return dummy1.next;
    }

     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
