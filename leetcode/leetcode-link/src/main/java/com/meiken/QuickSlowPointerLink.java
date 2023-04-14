package com.meiken;

/**
 * 快慢指针
 */
public class QuickSlowPointerLink {

    // even 偶数
    // odd 奇数
    public static void main(String[] args) {
        ListNode evenHead = ListNode.buildLink(new int[]{1,2,3,4,5,6});
        ListNode oddHead = ListNode.buildLink(new int[]{1,2,3,4,5});

        // 偶数链表
        ListNode.printLink(evenHead);
        slowFastPointer(evenHead);

        // 奇数链表
        ListNode.printLink(oddHead);
        slowFastPointer(oddHead);
    }

    public static void slowFastPointer(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.print("Slow->: ");
        ListNode.printLink(slow);
    }

    public static ListNode findSlowPointer(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
