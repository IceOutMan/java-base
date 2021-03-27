package linklist;

import linklist.common.ListNode;

/**
 * @Author glf
 * @Date 2021/3/14
 */
public class RotateList {
    public static void main(String[] args) {


    }

    public static ListNode rotateRight(ListNode head, int k){
        if(head == null || k == 0){
            return head;
        }

        int len = 1;
        ListNode cur = head;
        while(cur.next != null){
            cur = cur.next;
            len ++;
        }

        //形成环
        cur.next = head;
        k = len - k % len;

        for(int i=0; i< k; i++){
            cur = cur.next;
        }
        head = cur.next;
        cur.next = null;

        return head;

    }
}
