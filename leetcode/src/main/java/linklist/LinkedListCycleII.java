package linklist;

import linklist.common.ListNode;

/**
 * @Author glf
 * @Date 2021/3/15
 */
public class LinkedListCycleII {
    public static void main(String[] args) {

    }

    public static ListNode detectCycle(ListNode head){
        if(head == null){
            return null;
        }
        ListNode low = head;
        ListNode fast = head.next;

        while(low!=null && fast!=null){
            if(low == fast){
                //环
                ListNode low2 = head;
                while(true){
                    if(low2 == low){
                        return low;
                    }
                    low = low.next;
                    low2 = low2.next;
                }
            }
            low = low.next;
            fast = fast.next == null ? null : fast.next;
        }

        return null;
    }
}
