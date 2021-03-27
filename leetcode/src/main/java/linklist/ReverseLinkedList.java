package linklist;

import linklist.common.ListNode;

/**
 * @Author glf
 * @Date 2021/3/13
 */
public class ReverseLinkedList {


    public static ListNode reverseList(ListNode head) {

        if(head == null){
            return null;
        }

        ListNode cur = head.next;
        head.next = null;
        while(cur != null){
            ListNode curNext = cur.next;

            cur.next = head;
            head = cur;

            cur = curNext;
        }
        return head;

    }
}


