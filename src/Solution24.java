public class Solution24 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    //1.递归法
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null)  return head;
        ListNode n = head.next;
        head.next = swapPairs1(n.next);
        n.next = head;
        return n;
    }

    //2.非递归法
    public ListNode swapPairs2(ListNode head){
        ListNode dummy = new ListNode(0);
        ListNode point = dummy;
        dummy.next = head;
        while (point.next != null && point.next.next != null ){
            ListNode swap1 = point.next;
            ListNode swap2 = point.next.next;
            point.next = swap2;
            swap1.next = swap2.next;
            swap2.next = swap1;
            point = swap1;
        }
        return dummy.next;
    }

}
