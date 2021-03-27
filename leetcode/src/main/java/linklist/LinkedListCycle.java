package linklist;

import linklist.common.ListNode;

/**
 * @Author glf
 * @Date 2021/3/15
 */
public class LinkedListCycle {
    public static void main(String[] args) {

    }

    public static boolean hasCycle(ListNode head){
        if(head == null){
            return false;
        }

        ListNode low = head;
        ListNode fast = head.next;

        while(low != null && fast != null){
            if(low == fast){
                return true;
            }
            low = low.next;
            fast = fast.next == null ? null : fast.next.next;
        }

        return false;

    }
}
