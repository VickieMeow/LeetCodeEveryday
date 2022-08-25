/**
 * 删除重复元素类型，26、27都是这个
 * @author miaomeiqi
 */
public class Solution83 {
    class ListNode{
        int val;
        ListNode next;
    }

    /**
     * 删除链表中重复节点，类比Solution26删除数组中重复数字，思路一致
     * @link
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
