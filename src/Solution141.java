import java.util.HashSet;
import java.util.Set;


public class Solution141 {

    //1.hashmap/set法
    //每遍历一个结点，就存入set/map，下次遍历时看是否存在
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if(set.contains(head)) return true;
            else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }


    //2.快慢指针
    public boolean hasCycle2(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && slow != null && fast != null){
            if(fast == slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }


    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
