package linklist;

import linklist.common.ListNode;

/**
 * @Author glf
 * @Date 2021/3/14
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode head = ListNode.getListNode(1,2,3,4,5);
        head= reverseKGroup(head,3);
        ListNode.printListNode(head);
    }

    public static ListNode reverseKGroup(ListNode head, int k){
        return reverse(head,null,head,k);
    }

    public static ListNode reverse(ListNode head, ListNode preReverseStart,ListNode reverseStart, int k){
        if(!checkLength(reverseStart,k)){
            return head;
        }
        ListNode cur = reverseStart.next;
        for(int i=1;i<k;i++){
            if(cur != null){
               if(preReverseStart == null){
                   reverseStart.next = cur.next;
                   cur.next = head;
                   head = cur;

                   cur = reverseStart.next;
               }else{
                   reverseStart.next = cur.next;
                   cur.next = preReverseStart.next;
                   preReverseStart.next = cur;

                   cur = reverseStart.next;
               }
            }else {
                break;
            }
        }
        if(cur != null){
            return reverse(head,reverseStart,cur,k);
        }
        return head;
    }

    public static boolean checkLength(ListNode reverseStart, int k){
        ListNode cur = reverseStart;
        for(int i=0;i<k;i++){
            if(cur == null){
                return false;
            }
            cur = cur.next;
        }
        return true;
    }
}
