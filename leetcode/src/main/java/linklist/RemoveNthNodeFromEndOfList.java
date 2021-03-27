package linklist;

import linklist.common.ListNode;

/**
 * @Author glf
 * @Date 2021/3/14
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head = ListNode.getListNode(1,2,3,4,5);
        head = removeNthFromEnd(head,2);
        ListNode.printListNode(head);

    }

    public static ListNode removeNthFromEnd(ListNode head, int n){
        if(head == null || n == 0){
            return head;
        }

        ListNode cur = head;
        for(int i =0;i<n;i++){
            cur = cur.next;
        }

        // cur = n
        ListNode pre = null;
        ListNode curNode = head;
        while(cur !=null){

            pre = curNode;
            curNode = curNode.next;

            cur = cur.next;
        }
        // remove curNode
        if(pre == null){
            head = curNode.next;
        }else{
            pre.next = curNode.next;
        }
        return head;
    }
}
