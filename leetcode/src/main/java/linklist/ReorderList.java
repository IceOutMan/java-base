package linklist;

import linklist.common.ListNode;

/**
 * @Author glf
 * @Date 2021/3/15
 */
public class ReorderList {
    public static void main(String[] args) {


    }

    public void reorderList(ListNode head){
        if(head == null){
            return;
        }
        //中间结点断开
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode firstEnd = null;
        while(fast != null){
            if(fast.next == null){
                firstEnd = slow;
                break;
            }else if(fast.next.next == null){
                firstEnd = slow.next;
                break;
            }
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
        }
        //断开
        ListNode secondHead = firstEnd.next;
        firstEnd.next = null;

        //反转链表
        secondHead = reverse(secondHead);

        // 间隔插入
        ListNode firstCur = head;
        ListNode secondCur = secondHead;
        while(secondCur != null){
            ListNode temp = secondCur.next;

            secondCur.next = firstCur.next;
            firstCur.next = secondCur;

            secondCur = temp;
            firstCur = firstCur.next.next;
        }

    }

    public ListNode reverse(ListNode head){
        ListNode nullHead = new ListNode();
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = nullHead.next;
            nullHead.next = cur;

            cur = temp;
        }
        return  nullHead.next;
    }
}
