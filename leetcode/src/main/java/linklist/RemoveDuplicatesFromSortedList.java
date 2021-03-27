package linklist;

import linklist.common.ListNode;

/**
 * @Author glf
 * @Date 2021/3/13
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;

        while(cur != null){

            if(pre != null && pre.val == cur.val){
                //删除 cur
                pre.next = cur.next;
                cur = pre.next;

                continue;
            }
            pre = cur;
            cur = cur.next;
        }

        return head;
    }

}
