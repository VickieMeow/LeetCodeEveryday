public class Solution25 {
    class ListNode {
        int val;
        ListNode next;
    }

    /**
     * K个一组反转
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b != null) {
                b = b.next;
            } else {
                return head;
            }
        }
        ListNode p = reverseAtoB(a, b);
        a.next = reverseKGroup(b, k);
        return p;
    }

    /**
     * 给定头结点翻转链表
     */
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 翻转a到b之间的链表，b开区间，思路同翻转链表，只是把尾节点null换为了b判断
     */
    public ListNode reverseAtoB(ListNode a, ListNode b) {
        ListNode pre = null;
        ListNode cur = a;
        ListNode next = a;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
