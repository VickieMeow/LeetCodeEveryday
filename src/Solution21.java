//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution_21 {


    //1.非递归方法
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode res = new ListNode(0);
        ListNode point = res;
        while ((l1 != null) && (l2 != null)){
            if(l1.val <= l2.val) {
                point.next = new ListNode(l1.val);
                point = point.next;
                l1 = l1.next;
            }
            else {
                point.next = new ListNode(l2.val);
                point = point.next;
                l2 = l2.next;
            }
        }

        if(l1 == null) point.next = l2;
        if(l2 == null) point.next = l1;

        return res.next;
    }




    //2.递归方法
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        //recursion terminator
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val <= l2.val){
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }

    }






    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}