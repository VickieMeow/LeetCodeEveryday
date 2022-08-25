public class Solution19 {

     class ListNode {
       int val;
       ListNode next;
       ListNode(int val) { this.val = val; }
     }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = getKthFromEnd(dummy, n+1);
        p.next = p.next.next;
        return dummy.next;
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
