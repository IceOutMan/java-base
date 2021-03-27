package linklist;

import linklist.common.ListNode;

/**
 * @Author glf
 * @Date 2021/3/14
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {

    }

    public static ListNode swapPairs(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prePre = null;
        ListNode pre = head;
        ListNode cur = head.next;

        while(pre != null && cur != null){

            //交换 pre 和 cur
            if(prePre == null){
                pre.next = cur.next;
                cur.next = pre;
                head = cur;

                pre = head;
                cur = pre.next;
            }else{
                pre.next = cur.next;
                prePre.next = cur;
                cur.next = pre;

                pre = prePre.next;
                cur = pre.next;
            }

           if(cur.next != null){
               prePre = cur;
               pre = cur.next;
               cur = cur.next.next;
           }else {
               pre = null;
               cur = null;
           }
        }
        return head;
    }
}
