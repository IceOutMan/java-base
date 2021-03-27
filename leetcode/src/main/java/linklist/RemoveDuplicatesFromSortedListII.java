package linklist;

import linklist.common.ListNode;

/**
 * @Author glf
 * @Date 2021/3/13
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 *  Input: head = [1,2,3,3,4,4,5]
 *  Output: [1,2,5]
 */
public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        ListNode head = ListNode.getListNode(1, 1);
        head = deleteDuplicates(head);
        ListNode.printListNode(head);

    }


    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode prePre = null;
        ListNode pre = null;
        ListNode cur = head;

        while(cur != null){
            if(pre != null && pre.val == cur.val){
                ListNode removeStart = pre;
                ListNode removeEnd = findRemoveEnd(removeStart);

                if(prePre == null){
                    pre = null;
                    cur = removeEnd.next;
                    head = cur;
                    continue;
                }else{
                    prePre.next = removeEnd.next;

                    pre = prePre;
                    cur = removeEnd.next;
                    continue;
                }
            }

            prePre = pre;
            pre = cur;
            cur = cur.next;
        }

        return head;
    }

    public static ListNode findRemoveEnd(ListNode removeHead){
        ListNode pre = removeHead;
        ListNode cur = removeHead.next;
        while(cur != null ){
            if(cur.val != removeHead.val){
                return pre;
            }
            pre = cur;
            cur = cur.next;
        }
        return pre;
    }


}
