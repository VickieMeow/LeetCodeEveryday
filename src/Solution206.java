public class Solution206 {
    public Offer22.ListNode reverseList(Offer22.ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Offer22.ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
