package linklist;


import linklist.common.ListNode;

/**
 * @Author glf
 * @Date 2021/3/13
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class AddTwoNumbers {


    public static void main(String[] args) {
    }


    public static ListNode addTowNumbers(ListNode l1, ListNode l2){
        ListNode resultNullHead = new ListNode();
        ListNode tail = resultNullHead;

        ListNode curL1 = l1;
        ListNode curL2 = l2;

        int carry = 0;
        while(curL1 != null && curL2 != null){

            int sum = curL1.val + curL2.val + carry;
            int newVal = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode();
            newNode.val = newVal;
            newNode.next = null;

            tail.next = newNode;
            tail = newNode;

            curL1 = curL1.next;
            curL2 = curL2.next;
        }

        ListNode finalCur = null;
        if(curL1 != null){
            finalCur = curL1;
        }else if(curL2 != null){
            finalCur = curL2;
        }

        if(finalCur != null) {
            while(finalCur != null){
                int sum = finalCur.val + carry;
                int newVal = sum % 10;
                carry = sum / 10;

                ListNode newNode = new ListNode();
                newNode.val = newVal;
                newNode.next = null;

                tail.next = newNode;
                tail = newNode;

                finalCur= finalCur.next;
            }
        }

        if(carry == 1){
            ListNode newNode = new ListNode();
            newNode.val = carry;
            newNode.next = null;

            tail.next = newNode;
            tail = newNode;
        }

        return resultNullHead.next;
    }
}


